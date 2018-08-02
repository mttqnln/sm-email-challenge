package au.com.mttqnln.controller;

import au.com.mttqnln.EmailRequestBuilder;
import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.service.EmailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerTest {

  static {
    System.setProperty("MAIL_JET_AUTH", "FOO");
    System.setProperty("SEND_GRID_KEY", "BAR");
  }

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EmailSenderService emailSenderService;

  @Before
  public void setUpMock() {
    when(emailSenderService.sendEmail(any(EmailRequest.class))).thenReturn(HttpStatus.OK);
  }

  @Test
  public void sendController_withValidBody_returnsOk() throws Exception {
    mockMvc.perform(post("/email/send")
      .contentType(MediaType.APPLICATION_JSON)
      .content(stringify(new EmailRequestBuilder().build())))
      .andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void sendController_withInValidEmail_returnsBadRequest() throws Exception {
    List<String> toList = new ArrayList<>();
    toList.add("Thisisnotanemail");
    mockMvc.perform(post("/email/send")
      .contentType(MediaType.APPLICATION_JSON)
      .content(
        stringify(
          new EmailRequestBuilder()
            .withTo(toList)
            .build())))
      .andDo(print()).andExpect(status().isBadRequest());
  }

  // TODO test other validation methods

  private String stringify(Object object) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(object);
  }

}
