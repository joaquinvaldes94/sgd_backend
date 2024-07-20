package cl.nescorp.provider.aplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("message")
  private String message;
  @JsonProperty("passValid")
  private Boolean passValid;
public AuthenticationResponse(String accessToken, String refreshToken, String message) {
	super();
	this.accessToken = accessToken;
	this.refreshToken = refreshToken;
	this.message = message;
	this.passValid = null;
}
  
  
}
