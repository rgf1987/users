package crossfitmieres.usuarios.models;


import crossfitmieres.usuarios.dtos.request.RequestUsuarioBoxDto;
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
@Table(name = "USUARIO_BOX")
public class UsuarioBox {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    @Column(name = "APELLIDO1", nullable = false)
    private String apellido1;
    @Column(name = "APELLIDO2", nullable = false)
    private String apellido2;
    @Column(name = "DNI", nullable = false)
    private String dni;    

    public static UsuarioBox getEntidadDeDto(RequestUsuarioBoxDto dto) {
        return UsuarioBox.builder()
        		.dni(dto.getDni())
                .nombre(dto.getNombre())
                .apellido1(dto.getApellido1())
                .apellido2(dto.getApellido2())
                .build();
    }

}
