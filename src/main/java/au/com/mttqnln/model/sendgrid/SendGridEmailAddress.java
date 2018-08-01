package au.com.mttqnln.model.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SendGridEmailAddress {
  private String name;
  private String email;

  public SendGridEmailAddress() {}
  public SendGridEmailAddress(String email) {
    this.email = email;
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
