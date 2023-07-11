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
public class RequestBoxUserDto {

    private String name;
    private String lastName;

}
