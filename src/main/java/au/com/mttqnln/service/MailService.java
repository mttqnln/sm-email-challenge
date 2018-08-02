package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import org.springframework.http.HttpStatus;

public interface MailService {
  HttpStatus sendEmail(EmailRequest email);
}
