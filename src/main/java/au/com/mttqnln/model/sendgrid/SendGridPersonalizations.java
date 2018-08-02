package au.com.mttqnln.model.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SendGridPersonalizations {

  private List<SendGridEmailAddress> to = new ArrayList<>();
  private List<SendGridEmailAddress> cc = new ArrayList<>();
  private List<SendGridEmailAddress> bcc = new ArrayList<>();
  private String subject;

  public List<SendGridEmailAddress> getTo() {
    return to;
  }

  public void setTo(List<SendGridEmailAddress> to) {
    this.to = to;
  }

  public void addTo(SendGridEmailAddress emailAddress) {
    this.to.add(emailAddress);
  }

  public List<SendGridEmailAddress> getCc() {
    return cc;
  }

  public void setCc(List<SendGridEmailAddress> cc) {
    this.cc = cc;
  }

  public void addCc(SendGridEmailAddress emailAddress) {
    this.cc.add(emailAddress);
  }

  public List<SendGridEmailAddress> getBcc() {
    return bcc;
  }

  public void setBcc(List<SendGridEmailAddress> bcc) {
    this.bcc = bcc;
  }

  public void addBcc(SendGridEmailAddress emailAddress) {
    this.bcc.add(emailAddress);
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
