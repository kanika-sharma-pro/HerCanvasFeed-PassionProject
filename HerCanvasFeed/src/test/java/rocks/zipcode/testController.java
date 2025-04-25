package rocks.zipcode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class testController {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/users/allUsers"))
                .andExpect(status().isOk()); // Check for 200 OK
    }
    @Test
    public void testCreateUser() throws Exception {
        mockMvc.perform(post("/users/createUser")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // Important for form data
                        .param("name", "Test User")
                        .param("email", "test@example.com"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllUsers1() throws Exception {
        mockMvc.perform(get("/users/allUsers"))
                .andExpect(status().isOk())
                .andExpect(view().name("userlist")) // Check the view name
                .andExpect(content().contentType(MediaType.TEXT_HTML_VALUE));
    }







}