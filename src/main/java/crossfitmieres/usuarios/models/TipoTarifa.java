package crossfitmieres.usuarios.models;


import crossfitmieres.usuarios.dtos.request.RequestTipoTarifaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
In entities is better use Getter&Setter from Lombok, instead of @Data,
because this last one can have conflicts with JPA and with lazy load
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TIPO_TARIFA")
public class TipoTarifa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CODIGO", nullable = false)
    private String codigo;
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    @Column(name = "PRECIO", nullable = false)
    private String precio;
    @Column(name = "NUMERO_WODS")
    private String numeroWods;
    @Column(name = "NUMERO_OPENS")
    private String numeroOpens;
    
    public static TipoTarifa getEntidadDeDto(RequestTipoTarifaDto dto) {
        return TipoTarifa.builder()
                .codigo(dto.getCodigo())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .numeroWods(dto.getNumeroWods())
                .numeroOpens(dto.getNumeroOpens())
                .build();
    }

}
