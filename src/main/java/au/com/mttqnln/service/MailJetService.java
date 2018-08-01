package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.model.mailjet.MailJetEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MailJetService implements MailServiceInterface {

  private final String END_POINT = "https://api.mailjet.com/v3.1/send";

  @Value(("${MAIL_JET_AUTH}"))
  private String mailJetAuth;

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String sendEmail(EmailRequest email) {
    System.out.println(this.mailJetAuth);
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
    byte[] plainCredsBytes = mailJetAuth.getBytes();
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    headers.add("Authorization", "Basic " + base64Creds);
    HttpEntity<String> entity = new HttpEntity<>(mailJetJson, headers);

    ResponseEntity<String> response =  restTemplate.postForEntity(END_POINT, entity, String.class);
    return response.getBody();
  }
}
