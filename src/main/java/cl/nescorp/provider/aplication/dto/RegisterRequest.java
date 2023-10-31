package cl.nescorp.provider.aplication.dto;


import cl.nescorp.provider.aplication.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String nick;
  private String password;
  private Role role;
}
