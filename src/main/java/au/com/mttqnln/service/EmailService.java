package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  @Autowired
  MailJetService mailJetService;

  @Autowired
  SendGridService sendGridService;

  public String sendEmail(EmailRequest emailRequest) {
    return sendGridService.sendEmail(emailRequest);
  }

  public String sendMailJet(EmailRequest emailRequest) {
    return mailJetService.sendEmail(emailRequest);
  }
}
