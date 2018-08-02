package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.model.mailjet.MailJetEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Order(value=2)
public class MailJetService implements MailService {

  private final String END_POINT = "https://api.mailjet.com/v3.1/send";

  @Value(("${app.keys.mailjet}"))
  private String mailJetAuth;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public HttpStatus sendEmail(EmailRequest email) {
    MailJetEmail mailJetEmail = new MailJetEmail(email);
    RestTemplate restTemplate = new RestTemplate();
    String mailJetJson = null;
    try {
      mailJetJson = objectMapper.writeValueAsString(mailJetEmail);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    byte[] basicAuthBytes = mailJetAuth.getBytes();
    byte[] base64AuthBytes = Base64.encodeBase64(basicAuthBytes);
    String base64AuthString = new String(base64AuthBytes);

    headers.add("Authorization", "Basic " + base64AuthString);
    HttpEntity<String> entity = new HttpEntity<>(mailJetJson, headers);

    ResponseEntity<String> response =  restTemplate.postForEntity(END_POINT, entity, String.class);
    return response.getStatusCode();
  }
}
