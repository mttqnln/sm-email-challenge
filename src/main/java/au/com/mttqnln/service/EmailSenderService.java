package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class EmailSenderService {

  @Autowired
  private List<MailService> mailServices;

  public EmailSenderService() {}

  public EmailSenderService(List<MailService> mailServices) {
    this.mailServices = mailServices;
  }

  public HttpStatus sendEmail(EmailRequest emailRequest) {
    for (MailService mailService: mailServices) {
      try {
        HttpStatus httpStatus = mailService.sendEmail(emailRequest);
        // Check if in the 200 (success) range
        if (httpStatus.value() / 100 == 2) {
          return HttpStatus.OK;
        }
      } catch (ResourceAccessException ex) {
        // TODO log access exception to analytics/notification system. preferably not by email...
      }
    }
    return HttpStatus.SERVICE_UNAVAILABLE;
  }
}
