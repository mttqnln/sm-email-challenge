package au.com.mttqnln.model.sendgrid;

import au.com.mttqnln.EmailRequestBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class SendGridEmailTest {

  @Test
  public void constructor_validEmailRequestGiven_ShouldPopulateFieldsCorrectly() {
    SendGridEmail sendGridEmail = new SendGridEmail(
      new EmailRequestBuilder().build()
    );
    assertThat(sendGridEmail.getPersonalizations().size()).isEqualTo(1);
    SendGridPersonalizations personalization = sendGridEmail.getPersonalizations().get(0);
    assertThat(sendGridEmail.getFrom().getEmail()).isEqualTo("luke.skywalker@hoth.com");
    assertThat(sendGridEmail.getContent().size()).isEqualTo(1);
    assertThat(sendGridEmail.getContent().get(0).getValue()).isEqualTo("Hello World!");
    assertThat(personalization.getSubject()).isEqualTo("merger");
    assertThat(personalization.getTo().get(0).getEmail()).isEqualTo("mary.poppins@disney.com");
    assertThat(personalization.getCc().get(0).getEmail()).isEqualTo("timon@disney.com");
    assertThat(personalization.getBcc().get(0).getEmail()).isEqualTo("pumba@disney.com");
  }

  @Test
  public void constructor_emptyCopyFields_ShouldReturnEmptiesForCopyFields() {
    SendGridEmail sendGridEmail = new SendGridEmail(
      new EmailRequestBuilder()
        .withCc(null)
        .withBcc(null)
        .build()
    );
    assertThat(sendGridEmail.getPersonalizations().size()).isEqualTo(1);
    SendGridPersonalizations personalization = sendGridEmail.getPersonalizations().get(0);
    assertThat(personalization.getCc()).isEmpty();
    assertThat(personalization.getBcc()).isEmpty();
    assertThat(personalization.getTo()).isNotEmpty();
  }
}
