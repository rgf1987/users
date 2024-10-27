package crossfitmieres.usuarios.dtos.response;

import crossfitmieres.usuarios.models.UsuarioBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseUsuarioBoxDto {
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public static ResponseUsuarioBoxDto getDtoDeEntidad(UsuarioBox entidad) {
        return ResponseUsuarioBoxDto.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .apellido1(entidad.getApellido1())
                .apellido2(entidad.getApellido2())
                .build();
    }
}
