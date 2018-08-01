package au.com.mttqnln.model.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendGridPersonalizations {

  private List<SendGridEmailAddress> to;
  private List<SendGridEmailAddress> cc;
  private List<SendGridEmailAddress> bcc;
  private String subject;

  public SendGridPersonalizations() {
    this.to = new ArrayList<>();
    this.cc = new ArrayList<>();
    this.bcc = new ArrayList<>();
  }

  public List<SendGridEmailAddress> getTo() {
    if (to.size() <= 0) {
      return null;
    }
    return to;
  }

  public void setTo(List<SendGridEmailAddress> to) {
    this.to = to;
  }

  public void addTo(SendGridEmailAddress emailAddress) {
    this.to.add(emailAddress);
  }

  public List<SendGridEmailAddress> getCc() {
    if (cc.size() <= 0) {
      return null;
    }
    return cc;
  }

  public void setCc(List<SendGridEmailAddress> cc) {
    this.cc = cc;
  }

  public void addCc(SendGridEmailAddress emailAddress) {
    this.cc.add(emailAddress);
  }

  public List<SendGridEmailAddress> getBcc() {
    if (bcc.size() <= 0) {
      return null;
    }
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
