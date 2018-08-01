package au.com.mttqnln.model.sendgrid;

import au.com.mttqnln.model.EmailRequest;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class SendGridEmail {
  private List<SendGridPersonalizations> personalizations;
  private SendGridFrom from;
  private List<SendGridContent> content;

  public SendGridEmail() { }

  public SendGridEmail(EmailRequest emailRequest) {
    this.personalizations = new ArrayList<>();
    SendGridPersonalizations personalization = new SendGridPersonalizations();
    this.content = new ArrayList<>();
    SendGridContent contentItem = new SendGridContent();
    this.from = new SendGridFrom();
    if (emailRequest.getTo() != null) {
      for (String email : emailRequest.getTo()) {
        personalization.addTo(new SendGridEmailAddress(email));
      }
    }
    if (emailRequest.getCc() != null) {
      for (String email : emailRequest.getCc()) {
        personalization.addCc(new SendGridEmailAddress(email));
      }
    }
    if (emailRequest.getBcc() != null) {
      for (String email : emailRequest.getBcc()) {
        personalization.addBcc(new SendGridEmailAddress(email));
      }
    }
    personalization.setSubject(emailRequest.getSubject());
    this.personalizations.add(personalization);
    this.from.setEmail(emailRequest.getFrom());
    contentItem.setValue(emailRequest.getContent());
    this.content.add(contentItem);
  }

  public List<SendGridPersonalizations> getPersonalizations() {
    return personalizations;
  }

  public void setPersonalizations(List<SendGridPersonalizations> personalizations) {
    this.personalizations = personalizations;
  }

  public SendGridFrom getFrom() {
    return from;
  }

  public void setFrom(SendGridFrom from) {
    this.from = from;
  }

  public List<SendGridContent> getContent() {
    return content;
  }

  public void setContent(List<SendGridContent> content) {
    this.content = content;
  }
}
