package au.com.mttqnln.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class EmailRequest {

  @NotEmpty
  private List<@Email String> to = new ArrayList<>();

  private List<@Email String> cc = new ArrayList<>();

  private List<@Email String> bcc = new ArrayList<>();

  @NotNull
  @Email
  private String from;

  @NotNull
  @Size(min=2, message="should have at least 2 characters")
  private String subject;

  @NotNull
  private String content;

  public List<String> getTo() {
    return to;
  }

  public void setTo(List<String> to) {
    this.to = to;
  }

  public List<String> getCc() {
    return cc;
  }

  public void setCc(List<String> cc) {
    this.cc = cc;
  }

  public List<String> getBcc() {
    return bcc;
  }

  public void setBcc(List<String> bcc) {
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
