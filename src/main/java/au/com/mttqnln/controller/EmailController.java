package au.com.mttqnln.controller;

import au.com.mttqnln.model.EmailRequest;
import au.com.mttqnln.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailController {

  @Autowired
  EmailSenderService emailSenderService;

  @RequestMapping(value = "/send", method = RequestMethod.POST)
  public ResponseEntity sendEmail(@Valid @RequestBody EmailRequest emailRequest) {
    HttpStatus status = emailSenderService.sendEmail(emailRequest);
    return new ResponseEntity<>(status);
  }

}
