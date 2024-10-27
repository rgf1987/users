package crossfitmieres.usuarios.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestUsuarioBoxDto {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

}
