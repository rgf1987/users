package crossfitmieres.users.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import crossfitmieres.users.dtos.RequestBoxUserDto;
import crossfitmieres.users.dtos.ResponseBoxUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BoxUsersControllerTest {

    private static final String BASE_PATH = "/api/boxUsers";

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;

    BoxUsersControllerTest() {
    }

    @Test
    void findAllBoxUsers() throws Exception {
        String URL = BASE_PATH+"/findAllBoxUsers";
        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(URL)).andReturn();
        //then
        List<ResponseBoxUserDto> returnedBoxUsers =
                mapper.readValue(
                        mvcResult.getResponse().getContentAsString(),
                        new TypeReference<List<ResponseBoxUserDto>>() {});

        assertNotNull(returnedBoxUsers);
        assertTrue(returnedBoxUsers.size()>0);
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void findBoxUserById() throws Exception {
        String URL = BASE_PATH+"/findBoxUserById";
        //when
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get(URL).param("boxUserId", "1"))
                .andReturn();
        //then
        String json = mvcResult.getResponse().getContentAsString();
        ResponseBoxUserDto responseBoxUserDto = new ObjectMapper().readValue(json, ResponseBoxUserDto.class);
        assertNotNull(responseBoxUserDto);
        assertEquals(1, responseBoxUserDto.getId());
        assertEquals(200, mvcResult.getResponse().getStatus());



    }

    @Test
    void saveBoxUser() throws Exception {
        //given
        String URL = BASE_PATH+"/saveBoxUser";
        RequestBoxUserDto newBoxUserDto = new RequestBoxUserDto();
        newBoxUserDto.setName("Raul");
        newBoxUserDto.setLastName("Gonzalez Gonzalez");

        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(newBoxUserDto);

        //when
        MvcResult mvcResult = mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestJson))
                        .andExpect(status().isOk())
                        .andReturn();
        //then
        String json = mvcResult.getResponse().getContentAsString();
        ResponseBoxUserDto saveUserDto = new ObjectMapper().readValue(json, ResponseBoxUserDto.class);
        assertNotNull(saveUserDto);
        assertNotNull(saveUserDto.getId());
        assertEquals(200, mvcResult.getResponse().getStatus());

    }
}