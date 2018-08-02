package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.model.sendgrid.SendGridEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Order(value=1)
public class SendGridService implements MailService {

  private final String END_POINT = "https://api.sendgrid.com/v3/mail/send";

  @Value(("${app.keys.sendgrid}"))
  private String sendGridKey;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public HttpStatus sendEmail(EmailRequest emailRequest) {
    SendGridEmail sendGridEmail = new SendGridEmail(emailRequest);
    RestTemplate restTemplate = new RestTemplate();
    String sendGridJson = null;
    try {
      sendGridJson = objectMapper.writeValueAsString(sendGridEmail);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("authorization", sendGridKey);
    HttpEntity<String> entity = new HttpEntity<>(sendGridJson, headers);

    ResponseEntity<String> response =  restTemplate.postForEntity(END_POINT, entity, String.class);
    return response.getStatusCode();
  }
}
