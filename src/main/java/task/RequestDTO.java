package task;

import javax.persistence.Id;

public class RequestDTO {
	@Id
	String requestId;
	Integer attempt;
	String methodName;
	String[] args;
	public String getRequestId() {
		return requestId;
	}
	public Integer getAttempt() {
		return attempt;
	}
	public String getMethodName() {
		return methodName;
	}
	public String[] getArgs() {
		return args;
	}
	
	
	
}