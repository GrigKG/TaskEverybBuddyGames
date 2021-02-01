package task;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Task {

	static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	Repository Repository;

	public void handle(String JSON) throws JsonMappingException, JsonProcessingException {
		RequestDTO requestDTO = mapper.readValue(JSON, RequestDTO.class);	
		if (!Repository.existsById(requestDTO.getRequestId())) {
			String processRequest = processRequest(requestDTO.getRequestId(), requestDTO.getAttempt(),
					requestDTO.getMethodName(), requestDTO.getArgs());
			RestoreDTO restoreDTO = mapper.readValue(processRequest, RestoreDTO.class);
			if ("Success".equals(restoreDTO.getStatus())) {
				Repository.save(requestDTO);
			}
		}
	}
	
	//given method
	public String processRequest(String requestId, Integer attempt, String methodName, String[] args) {
		return null;
	}
}
