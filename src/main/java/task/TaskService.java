package task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TaskService {

	static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	Repository repositorySuccessRequest;

	private static final String SUCCESS = "Success";

	public ResponseDTO handle(RequestDTO requestDTO) throws JsonMappingException, JsonProcessingException {
		if (repositorySuccessRequest.existsById(requestDTO.getRequestId())) throw new RuntimeException();
		String processRequest = processRequest(requestDTO.getRequestId(), requestDTO.getAttempt(),
				requestDTO.getMethodName(), requestDTO.getArgs());
		ResponseDTO response = mapper.readValue(processRequest, ResponseDTO.class);
		if (SUCCESS.equals(response.getStatus())) {
			repositorySuccessRequest.save(requestDTO);
		}
		return response;
	}
	
	//given method
	public String processRequest(String requestId, Integer attempt, String methodName, List<String> args) {
		return null;
	}
}
