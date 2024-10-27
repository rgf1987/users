package crossfitmieres.usuarios.dtos.response;

import crossfitmieres.usuarios.models.TipoTarifa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseTipoTarifaDto {

	private Long id;
    private String codigo;
    private String descripcion;
    private String precio;
    private String numeroWods;
    private String numeroOpens;
    
    public static ResponseTipoTarifaDto getDtoDeEntidad(TipoTarifa entidad) {
        return ResponseTipoTarifaDto.builder()
                .id(entidad.getId())
                .codigo(entidad.getCodigo())
                .descripcion(entidad.getDescripcion())
                .precio(entidad.getPrecio())
                .numeroWods(entidad.getNumeroWods())
                .numeroOpens(entidad.getNumeroOpens())
                .build();
    }

}
