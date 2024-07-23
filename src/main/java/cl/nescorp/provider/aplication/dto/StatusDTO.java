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
public class StatusDTO {
	
	
	private int code;
	private Boolean hasError;

	public StatusDTO(HttpStatus status) {
		this.code = status.value();
		this.hasError = status.isError();
	}
}
