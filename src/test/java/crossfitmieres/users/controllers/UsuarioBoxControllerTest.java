package crossfitmieres.users.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import crossfitmieres.usuarios.dtos.request.RequestUsuarioBoxDto;
import crossfitmieres.usuarios.dtos.response.ResponseUsuarioBoxDto;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioBoxControllerTest {

    private static final String BASE_PATH = "/api/boxUsers";

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper; 

    UsuarioBoxControllerTest() {
    }

    @Test
    void findAllBoxUsers() throws Exception {
        String URL = BASE_PATH;
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(URL))
                .andExpect(status().isOk())
                .andReturn();
        //then
        List<ResponseUsuarioBoxDto> returnedBoxUsers =
                mapper.readValue(
                        mvcResult.getResponse().getContentAsString(),
                        new TypeReference<List<ResponseUsuarioBoxDto>>() {});

        assertNotNull(returnedBoxUsers);
        assertTrue(returnedBoxUsers.size()>0);

    }

    @Test
    void findBoxUserById() throws Exception {
    	//given
        Long userId = 1L; //ID
        String URL = BASE_PATH + "/" + userId; // Usa el ID en la ruta
        //when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(URL))
                .andExpect(status().isOk()) // Espera un 200 OK
                .andReturn();
        //then
        String json = mvcResult.getResponse().getContentAsString();
        ResponseUsuarioBoxDto responseBoxUserDto = objectMapper.readValue(json, ResponseUsuarioBoxDto.class);
        assertNotNull(responseBoxUserDto);
        assertEquals(1, responseBoxUserDto.getId());
    }

    @Test
    void saveBoxUser() throws Exception {
        //given
        String URL = BASE_PATH;
        RequestUsuarioBoxDto newBoxUserDto = new RequestUsuarioBoxDto();
        newBoxUserDto.setNombre("Raul");
        newBoxUserDto.setApellido1("Gonzalez");
        newBoxUserDto.setApellido2("Fernandez");

        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(newBoxUserDto);

        //when
        MvcResult mvcResult = mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson))
                        .andExpect(status().isCreated())
                        .andReturn();
        //then
        String json = mvcResult.getResponse().getContentAsString();
        ResponseUsuarioBoxDto saveUserDto = objectMapper.readValue(json, ResponseUsuarioBoxDto.class);
        assertNotNull(saveUserDto);
        assertNotNull(saveUserDto.getId());
    }

    @Test
    void deleteBoxUserById() throws Exception {
    	//given
        Long userId = 1L; //ID
        String URL = BASE_PATH + "/" + userId; // Usa el ID en la ruta
        //when
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(URL)) // Elimina el parámetro de consulta
                .andExpect(status().isNoContent()); // Espera un 204 No Content


    }
}