package crossfitmieres.users.services;

import crossfitmieres.users.dtos.BoxUserDto;
import crossfitmieres.users.repositories.BoxUsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoxUsersService {

    private BoxUsersRepository userRepository;

    public List<BoxUserDto> findAllUsers(){
        return this.userRepository.findAll().stream().map(BoxUserDto::ofEntity).collect(Collectors.toList());
    }
}
