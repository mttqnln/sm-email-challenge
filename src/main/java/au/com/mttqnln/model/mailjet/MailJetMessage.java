package au.com.mttqnln.model.mailjet;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailJetMessage {

  private MailJetEmailAddress From;
  private List<MailJetEmailAddress> To;
  private List<MailJetEmailAddress> Cc;
  private List<MailJetEmailAddress> Bcc;
  private String Subject;
  private String TextPart;

  public MailJetMessage() {
    this.To = new ArrayList<>();
    this.Cc = new ArrayList<>();
    this.Bcc = new ArrayList<>();
  }

  public MailJetEmailAddress getFrom() {
    return From;
  }

  public void setFrom(MailJetEmailAddress from) {
    From = from;
  }

  public List<MailJetEmailAddress> getTo() {
    if (To.size() <= 0) {
      return null;
    }
    return To;
  }

  public void setTo(List<MailJetEmailAddress> to) {
    To = to;
  }

  public void addTo(MailJetEmailAddress to) {
    To.add(to);
  }

  public List<MailJetEmailAddress> getCc() {
    if (Cc.size() <= 0) {
      return null;
    }
    return Cc;
  }

  public void setCc(List<MailJetEmailAddress> cc) {
    Cc = cc;
  }

  public void addCc(MailJetEmailAddress cc) {
    Cc.add(cc);
  }

  public List<MailJetEmailAddress> getBcc() {
    if (Bcc.size() <= 0) {
      return null;
    }
    return Bcc;
  }

  public void setBcc(List<MailJetEmailAddress> bcc) {
    Bcc = bcc;
  }

  public void addBcc(MailJetEmailAddress bcc) {
    Bcc.add(bcc);
  }

  public String getSubject() {
    return Subject;
  }

  public void setSubject(String subject) {
    Subject = subject;
  }

  public String getTextPart() {
    return TextPart;
  }

  public void setTextPart(String textPart) {
    TextPart = textPart;
  }
}
