package au.com.mttqnln.model.mailjet;

import au.com.mttqnln.EmailRequestBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MailJetEmailTest {

  @Test
  public void constructor_validEmailRequestGiven_ShouldPopulateFieldsCorrectly() {
    MailJetEmail mailJetEmail = new MailJetEmail(
      new EmailRequestBuilder().build()
    );
    assertThat(mailJetEmail.getMessages().size()).isEqualTo(1);
    MailJetMessage mailJetMessage = mailJetEmail.getMessages().get(0);
    assertThat(mailJetMessage.getFrom().getEmail()).isEqualTo("luke.skywalker@hoth.com");
    assertThat(mailJetMessage.getSubject()).isEqualTo("merger");
    assertThat(mailJetMessage.getTextPart()).isEqualTo("Hello World!");
    assertThat(mailJetMessage.getTo().get(0).getEmail()).isEqualTo("mary.poppins@disney.com");
    assertThat(mailJetMessage.getCc().get(0).getEmail()).isEqualTo("timon@disney.com");
    assertThat(mailJetMessage.getBcc().get(0).getEmail()).isEqualTo("pumba@disney.com");
  }

  @Test
  public void constructor_emptyCopyFields_ShouldReturnNullsForCopyFields() {
    MailJetEmail mailJetEmail = new MailJetEmail(
      new EmailRequestBuilder()
        .withCc(null)
        .withBcc(null)
        .build()
    );
    assertThat(mailJetEmail.getMessages().size()).isEqualTo(1);
    MailJetMessage mailJetMessage = mailJetEmail.getMessages().get(0);
    assertThat(mailJetMessage.getCc()).isEmpty();
    assertThat(mailJetMessage.getBcc()).isEmpty();
    assertThat(mailJetMessage.getTo()).isNotEmpty();
  }
}
