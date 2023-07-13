package crossfitmieres.users.controllers;

import crossfitmieres.users.dtos.RequestBoxUserDto;
import crossfitmieres.users.exceptions.GenericErrorDto;
import crossfitmieres.users.services.BoxUsersService;
import crossfitmieres.users.dtos.ResponseBoxUserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all box users", description = "Return all the box users", operationId = "findAllBoxUsers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok, successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseBoxUserDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/findAllBoxUsers")
    public ResponseEntity<List<ResponseBoxUserDto>> findAllBoxUsers() {
        return new ResponseEntity<List<ResponseBoxUserDto>>(boxUsersService.findAllBoxUsers(), HttpStatus.OK);
    }

    @Operation(summary = "Get box users", description = "Get user by id", operationId = "findBoxUserById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok, successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseBoxUserDto.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/findBoxUserById")
    public ResponseEntity<ResponseBoxUserDto> findBoxUserById(@RequestParam(name="boxUserId") Long boxUserId) {
        return new ResponseEntity<ResponseBoxUserDto>(boxUsersService.findBoxUserById(boxUserId), HttpStatus.OK);
    }

    @PostMapping("/saveBoxUser")
    public ResponseEntity<ResponseBoxUserDto> saveBoxUser(@RequestBody RequestBoxUserDto requestBoxUserDto) {
        return new ResponseEntity<ResponseBoxUserDto>(boxUsersService.saveBoxUser(requestBoxUserDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBoxUser")
    public ResponseEntity<?> deleteBoxUser(@RequestParam(name="boxUserId") Long boxUserId) {
        boxUsersService.deleteBoxUser(boxUserId);
        return ResponseEntity.noContent().build();
    }
}
