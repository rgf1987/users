package crossfitmieres.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import crossfitmieres.usuarios.dtos.request.RequestUsuarioBoxDto;
import crossfitmieres.usuarios.dtos.response.ResponseUsuarioBoxDto;
import crossfitmieres.usuarios.models.UsuarioBox;
import crossfitmieres.usuarios.repositories.UsuarioBoxRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioBoxService {

    private UsuarioBoxRepository usuarioBoxRepository;

    public List<ResponseUsuarioBoxDto> findAllBoxUsers(){
        return this.usuarioBoxRepository.findAll()
        		.stream()
        		.map(ResponseUsuarioBoxDto::getDtoDeEntidad).toList();
    }

    public ResponseUsuarioBoxDto findBoxUserById(Long boxUserId) {
         return this.usuarioBoxRepository.findById(boxUserId)
                 .map(ResponseUsuarioBoxDto::getDtoDeEntidad)
                 .orElseThrow(() -> new EntityNotFoundException(String.valueOf(boxUserId)));
    }

    public ResponseUsuarioBoxDto saveBoxUser(RequestUsuarioBoxDto requestBoxUserDto) {
        UsuarioBox savedBoxUser = this.usuarioBoxRepository.save(UsuarioBox.getEntidadDeDto(requestBoxUserDto));
        return ResponseUsuarioBoxDto.getDtoDeEntidad(savedBoxUser);
    }


    public boolean deleteBoxUser(Long id) {
        Optional<UsuarioBox> user = usuarioBoxRepository.findById(id);
        if (user.isPresent()) {
            usuarioBoxRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
