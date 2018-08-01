package au.com.mttqnln.controller;

import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.model.mailjet.MailJetEmail;
import au.com.mttqnln.model.sendgrid.SendGridEmail;
import au.com.mttqnln.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

  @Autowired
  EmailService emailService;

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
    String response = emailService.sendEmail(emailRequest);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public ResponseEntity<SendGridEmail> testEmail(@RequestBody EmailRequest emailRequest) {
    SendGridEmail sendGridEmail = new SendGridEmail(emailRequest);
    return new ResponseEntity<>(sendGridEmail, HttpStatus.OK);
  }

  @RequestMapping(value = "/mj", method = RequestMethod.POST)
  public ResponseEntity<String> sendMailjet(@RequestBody EmailRequest emailRequest) {
    String response = emailService.sendMailJet(emailRequest);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @RequestMapping(value = "/mjtest", method = RequestMethod.POST)
  public ResponseEntity<MailJetEmail> testMailJet(@RequestBody EmailRequest emailRequest) {
    MailJetEmail mailJetEmail = new MailJetEmail(emailRequest);
    return new ResponseEntity<>(mailJetEmail, HttpStatus.OK);
  }
}
