package cl.nescorp.provider.aplication.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	
	private StatusDTO status;
	private Object data;
	
	public ResponseDTO(HttpStatus status, Object data) {
		this.status = new StatusDTO(status);
		this.data = data;
		
		// TODO Auto-generated constructor stub
	}
}
