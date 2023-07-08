package crossfitmieres.users.controllers;

import crossfitmieres.users.services.BoxUsersService;
import crossfitmieres.users.dtos.BoxUserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/boxUsers")
@AllArgsConstructor
public class BoxUsersController {

    private final BoxUsersService userService;

    @GetMapping("/findAllUsers")
    public List<BoxUserDto> findAllUsers() {
        return userService.findAllUsers();
    }
}
