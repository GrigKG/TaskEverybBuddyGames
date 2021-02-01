package task;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task {

	static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	Repository repository;

	private String SUCCESS = "Success";

	public RestoreDTO handle(RequestDTO requestDTO) throws JsonMappingException, JsonProcessingException {
		if (!repository.existsById(requestDTO.getRequestId())) throw new RuntimeException();
		String processRequest = processRequest(requestDTO.getRequestId(), requestDTO.getAttempt(),
				requestDTO.getMethodName(), requestDTO.getArgs());
		RestoreDTO restoreDTO = mapper.readValue(processRequest, RestoreDTO.class);
		if (SUCCESS.equals(restoreDTO.getStatus())) {
			repository.save(requestDTO);
		}
		return restoreDTO;
	}
	
	//given method
	public String processRequest(String requestId, Integer attempt, String methodName, String[] args) {
		return null;
	}
}
