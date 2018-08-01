package au.com.mttqnln.model.mailjet;

import au.com.mttqnln.model.EmailRequest;

import java.util.ArrayList;
import java.util.List;

public class MailJetEmail {

  private List<MailJetMessage> Messages;

  public MailJetEmail() {}

  public MailJetEmail(EmailRequest emailRequest) {
    this.Messages = new ArrayList<>();
    MailJetMessage mailJetMessage = new MailJetMessage();
    mailJetMessage.setSubject(emailRequest.getSubject());
    mailJetMessage.setTextPart(emailRequest.getContent());
    if (emailRequest.getTo() != null) {
      for (String email : emailRequest.getTo()) {
        mailJetMessage.addTo(new MailJetEmailAddress(email));
      }
    }
    if (emailRequest.getCc() != null) {
      for (String email : emailRequest.getCc()) {
        mailJetMessage.addCc(new MailJetEmailAddress(email));
      }
    }
    if (emailRequest.getBcc() != null) {
      for (String email : emailRequest.getBcc()) {
        mailJetMessage.addBcc(new MailJetEmailAddress(email));
      }
    }
    mailJetMessage.setFrom(new MailJetEmailAddress(emailRequest.getFrom()));
    this.Messages.add(mailJetMessage);
  }

  public List<MailJetMessage> getMessages() {
    return Messages;
  }

  public void setMessages(List<MailJetMessage> messages) {
    Messages = messages;
  }
}
