package rs.fon.silab.rest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    //spring.test.web.servlet.request.MockMvcRequestBuilders
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public  void saveUserSuccessTest() throws Exception {
        User user = new User();
        when(userService.save(user)).thenReturn(user);
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(user)))

                .andExpect(jsonPath("$.id", equalTo(user.getId())))
                .andExpect(jsonPath("$.name", equalTo(user.getName())));
    }

    @Test
    public  void saveUserFailTest() throws Exception {
        User user = new User();
        when(userService.save(user)).thenThrow(IllegalArgumentException.class)
        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void findAllTest() throws Exception {
        User user1 = new User();
        User user2 = new User();
        when(userService.findAll()).thenReturn(Arrays.asList(user1, user2));
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn();

        List<User> returnerUsers = objectMapper.readValue(result.getResponse().getContentAsString(),
                                                            new TypeReference<List<User>>(){});
        assertTrue(returnerUsers.connains(user1));
        assertTrue(returnerUsers.connains(user2));
    }

}
