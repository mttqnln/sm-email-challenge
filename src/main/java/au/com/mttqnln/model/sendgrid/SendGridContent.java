package au.com.mttqnln.model.sendgrid;

public class SendGridContent {

  private String type;
  private String value;

  public SendGridContent() {
    //Only supporting text/plain for this challenge
    this.type = "text/plain";
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
