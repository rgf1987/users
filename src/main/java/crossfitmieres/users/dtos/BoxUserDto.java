package crossfitmieres.users.dtos;

import crossfitmieres.users.models.BoxUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoxUserDto {
    private Long id;
    private String name;
    private String lastName;
    private Date registerDate;
    private Date unregisterDate;

    public static BoxUserDto ofEntity(BoxUser entity) {
        return BoxUserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .registerDate(entity.getRegisterDate())
                .unregisterDate(entity.getUnregisterDate())
                .build();
    }
}
