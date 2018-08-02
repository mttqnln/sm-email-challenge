package au.com.mttqnln;

import au.com.mttqnln.model.EmailRequest;

import java.util.ArrayList;
import java.util.List;

public class EmailRequestBuilder {

  private List<String> to = new ArrayList<>();
  private List<String> cc = new ArrayList<>();
  private List<String> bcc = new ArrayList<>();
  private String from = "luke.skywalker@hoth.com";
  private String subject = "merger";
  private String content = "Hello World!";

  public EmailRequestBuilder() {
    to.add("mary.poppins@disney.com");
    to.add("simba@disney.com");
    cc.add("timon@disney.com");
    bcc.add("pumba@disney.com");
  }

  public EmailRequestBuilder withTo(List<String> to) {
    this.to = to;
    return this;
  }

  public EmailRequestBuilder withCc(List<String> cc) {
    this.cc = cc;
    return this;
  }

  public EmailRequestBuilder withBcc(List<String> bcc) {
    this.bcc = bcc;
    return this;
  }

  public EmailRequestBuilder withFrom(String from) {
    this.from = from;
    return this;
  }

  public EmailRequestBuilder withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public EmailRequestBuilder withContent(String content) {
    this.content = content;
    return this;
  }

  public EmailRequest build() {
    EmailRequest emailRequest = new EmailRequest();
    emailRequest.setTo(this.to);
    emailRequest.setCc(this.cc);
    emailRequest.setBcc(this.bcc);
    emailRequest.setFrom(this.from);
    emailRequest.setSubject(this.subject);
    emailRequest.setContent(this.content);
    return emailRequest;
  }

}
