package crossfitmieres.users.controllers;

import crossfitmieres.users.dtos.RequestBoxUserDto;
import crossfitmieres.users.services.BoxUsersService;
import crossfitmieres.users.dtos.ResponseBoxUserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxUsers")
@AllArgsConstructor
public class BoxUsersController {

    private final BoxUsersService boxUsersService;

    @GetMapping("/findAllBoxUsers")
    public List<ResponseBoxUserDto> findAllBoxUsers() {
        return boxUsersService.findAllBoxUsers();
    }

    @GetMapping("/findBoxUserById")
    public ResponseBoxUserDto findBoxUserById(@RequestParam(name="boxUserId") Long boxUserId) {
        return boxUsersService.findBoxUserById(boxUserId);
    }

    @PostMapping("/saveBoxUser")
    public ResponseBoxUserDto saveBoxUser(@RequestBody RequestBoxUserDto requestBoxUserDto) {
        return boxUsersService.saveBoxUser(requestBoxUserDto);
    }
}
