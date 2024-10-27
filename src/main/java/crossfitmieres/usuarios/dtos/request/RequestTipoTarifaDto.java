package crossfitmieres.usuarios.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestTipoTarifaDto {

    private String codigo;
    private String descripcion;
    private String precio;
    private String numeroWods;
    private String numeroOpens;

}
