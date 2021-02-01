package task;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7879330160408241683L;
	@Id
	String requestId;
	Integer attempt;
	String methodName;
	@ElementCollection
	List<String> args;
}