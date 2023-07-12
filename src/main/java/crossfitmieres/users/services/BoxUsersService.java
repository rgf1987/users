package crossfitmieres.users.services;

import crossfitmieres.users.dtos.RequestBoxUserDto;
import crossfitmieres.users.dtos.ResponseBoxUserDto;
import crossfitmieres.users.models.BoxUser;
import crossfitmieres.users.repositories.BoxUsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoxUsersService {

    private BoxUsersRepository userRepository;

    public List<ResponseBoxUserDto> findAllBoxUsers(){
        return this.userRepository.findAll().stream().map(ResponseBoxUserDto::ofEntity).collect(Collectors.toList());
    }

    public ResponseBoxUserDto findBoxUserById(Long boxUserId) {
         return this.userRepository.findById(boxUserId)
                 .map(ResponseBoxUserDto::ofEntity)
                 .orElseThrow(() -> new EntityNotFoundException(String.valueOf(boxUserId)));
    }

    public ResponseBoxUserDto saveBoxUser(RequestBoxUserDto requestBoxUserDto) {
        BoxUser savedBoxUser = this.userRepository.save(BoxUser.ofDto(requestBoxUserDto));
        return ResponseBoxUserDto.ofEntity(savedBoxUser);
    }


    public void deleteBoxUser(Long boxUserId) {
        this.userRepository.deleteById(boxUserId);
    }
}
