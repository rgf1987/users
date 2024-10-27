package crossfitmieres.usuarios.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crossfitmieres.usuarios.dtos.request.RequestUsuarioBoxDto;
import crossfitmieres.usuarios.dtos.response.ResponseUsuarioBoxDto;
import crossfitmieres.usuarios.services.UsuarioBoxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
@CrossOrigin
@RestController
@RequestMapping("/api/boxUsers")
@AllArgsConstructor
public class UsuarioBoxController {

    private final UsuarioBoxService boxUsersService;

	@Operation(summary = "Obtener todos los usuarios de box", description = "Devuelve una lista de todos los usuarios de box.", operationId = "findAllBoxUsers")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ResponseUsuarioBoxDto.class)))),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping
	public ResponseEntity<List<ResponseUsuarioBoxDto>> findAllBoxUsers() {
		List<ResponseUsuarioBoxDto> boxUsers = boxUsersService.findAllBoxUsers();
		return ResponseEntity.ok(boxUsers);
	}

	@Operation(summary = "Obtener usuario por ID", description = "Recupera un usuario de box basado en el ID proporcionado.", operationId = "findBoxUserById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseUsuarioBoxDto.class))),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseUsuarioBoxDto> findBoxUserById(@PathVariable Long id) {
		ResponseUsuarioBoxDto user = boxUsersService.findBoxUserById(id);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@Operation(summary = "Guardar nuevo usuario de box", description = "Crea un nuevo usuario de box.", operationId = "saveBoxUser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente",
                    content = @Content(schema = @Schema(implementation = ResponseUsuarioBoxDto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ResponseUsuarioBoxDto> saveBoxUser(@RequestBody RequestUsuarioBoxDto requestBoxUserDto) {
        ResponseUsuarioBoxDto savedUser = boxUsersService.saveBoxUser(requestBoxUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar usuario de box", description = "Elimina un usuario de box basado en el ID proporcionado.", operationId = "deleteBoxUser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario eliminado exitosamente",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoxUser(@PathVariable Long id) {
        boolean isDeleted = boxUsersService.deleteBoxUser(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
