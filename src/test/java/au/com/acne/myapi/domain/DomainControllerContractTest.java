package au.com.acne.myapi.domain;

import au.com.acne.myapi.Code;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * An example of contract testing, using the new WebMvcTest annotation, allowing you to just instantiate
 * the controller of interest in the web layer only, not the entire application.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DomainController.class)
public class DomainControllerContractTest {

    /**
     * you can now mock concrete classes - yay!
     */
    @MockBean
    private DomainService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        when(service.serveWithName(any(String.class))).thenReturn(DomainResponse.of("Hello World", Code.OK));
        this.mockMvc.perform(get("/domain")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"content\":\"Hello World\",\"code\":\"OK\"}")));
    }

}
