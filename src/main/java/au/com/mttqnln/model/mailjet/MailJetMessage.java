package au.com.mttqnln.model.mailjet;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MailJetMessage {

  private MailJetEmailAddress From;
  private List<MailJetEmailAddress> To = new ArrayList<>();
  private List<MailJetEmailAddress> Cc = new ArrayList<>();
  private List<MailJetEmailAddress> Bcc = new ArrayList<>();
  private String Subject;
  private String TextPart;

  public MailJetEmailAddress getFrom() {
    return From;
  }

  public void setFrom(MailJetEmailAddress from) {
    From = from;
  }

  public List<MailJetEmailAddress> getTo() {
    return To;
  }

  public void setTo(List<MailJetEmailAddress> to) {
    To = to;
  }

  public void addTo(MailJetEmailAddress to) {
    To.add(to);
  }

  public List<MailJetEmailAddress> getCc() {
    return Cc;
  }

  public void setCc(List<MailJetEmailAddress> cc) {
    Cc = cc;
  }

  public void addCc(MailJetEmailAddress cc) {
    Cc.add(cc);
  }

  public List<MailJetEmailAddress> getBcc() {
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
