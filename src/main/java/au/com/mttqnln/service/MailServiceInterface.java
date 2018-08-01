package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;

public interface MailServiceInterface {
  public String sendEmail(EmailRequest email);
}
