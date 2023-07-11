package crossfitmieres.users.controllers;

import crossfitmieres.users.dtos.RequestBoxUserDto;
import crossfitmieres.users.services.BoxUsersService;
import crossfitmieres.users.dtos.ResponseBoxUserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxUsers")
@AllArgsConstructor
public class BoxUsersController {

    private final BoxUsersService boxUsersService;

    @GetMapping("/findAllBoxUsers")
    public ResponseEntity<List<ResponseBoxUserDto>> findAllBoxUsers() {
        return new ResponseEntity<List<ResponseBoxUserDto>>(boxUsersService.findAllBoxUsers(), HttpStatus.OK);
    }

    @GetMapping("/findBoxUserById")
    public ResponseEntity<ResponseBoxUserDto> findBoxUserById(@RequestParam(name="boxUserId") Long boxUserId) {
        return new ResponseEntity<ResponseBoxUserDto>(boxUsersService.findBoxUserById(boxUserId), HttpStatus.OK);
    }

    @PostMapping("/saveBoxUser")
    public ResponseEntity<ResponseBoxUserDto> saveBoxUser(@RequestBody RequestBoxUserDto requestBoxUserDto) {
        return new ResponseEntity<ResponseBoxUserDto>(boxUsersService.saveBoxUser(requestBoxUserDto), HttpStatus.CREATED);
    }
}
