package au.com.mttqnln.model;

public class EmailRequest {

  private String[] to = new String[]{};
  private String[] cc = new String[]{};
  private String[] bcc = new String[]{};
  private String from;
  private String subject;
  private String content;

  public String[] getTo() {
    return to;
  }

  public void setTo(String[] to) {
    this.to = to;
  }

  public String[] getCc() {
    return cc;
  }

  public void setCc(String[] cc) {
    this.cc = cc;
  }

  public String[] getBcc() {
    return bcc;
  }

  public void setBcc(String[] bcc) {
    this.bcc = bcc;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
