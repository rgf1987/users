package crossfitmieres.users.models;


import crossfitmieres.users.dtos.RequestBoxUserDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;


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
@Table(name = "BOXUSERS")
public class BoxUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "REGISTER_DATE", nullable = false, updatable = false)
    @CreationTimestamp
    private Date registerDate;
    @Column(name = "UNREGISTER_DATE")
    private Date unregisterDate;

    public static BoxUser ofDto(RequestBoxUserDto dto) {
        return BoxUser.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .build();
    }

}
