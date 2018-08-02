package au.com.mttqnln.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

  private String message;
  private List<String> details;

  public ErrorResponse() {
    this.details = new ArrayList<>();
  }

  public ErrorResponse(String message) {
    this();
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getDetails() {
    return details;
  }

  public void addDetails(String detail) {
    this.details.add(detail);
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }
}
