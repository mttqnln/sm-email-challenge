package au.com.mttqnln.service;

import au.com.mttqnln.model.EmailRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmailSenderServiceTest {

  @Mock
  private MailService mailService1;

  @Mock
  private MailService mailService2;

  @Mock
  private MailService failService1;

  @Mock
  private MailService failService2;

  @Mock
  private EmailRequest emailRequest;

  @Spy
  private List<MailService> mailServices;

  @Before
  public void setUpMock() {
    when(mailService1.sendEmail(emailRequest)).thenReturn(HttpStatus.OK);
    when(mailService2.sendEmail(emailRequest)).thenReturn(HttpStatus.OK);
    when(failService1.sendEmail(emailRequest)).thenReturn(HttpStatus.SERVICE_UNAVAILABLE);
    when(failService2.sendEmail(emailRequest)).thenReturn(HttpStatus.SERVICE_UNAVAILABLE);
    this.mailServices = new ArrayList<>();
  }

  @Test
  public void sendEmail_twoValidServices_SecondServiceNeverCalledReturnSuccess() {
    mailServices.add(mailService1);
    mailServices.add(mailService2);
    EmailSenderService emailSenderService = new EmailSenderService(mailServices);
    assertThat(emailSenderService.sendEmail(emailRequest)).isEqualTo(HttpStatus.OK);
    verify(mailService1, times(1)).sendEmail(emailRequest);
    verify(mailService2, never()).sendEmail(emailRequest);
  }

  @Test
  public void sendEmail_oneFailService_SecondServiceCalledReturnSuccess() {
    mailServices.add(failService1);
    mailServices.add(mailService2);
    EmailSenderService emailSenderService = new EmailSenderService(mailServices);
    assertThat(emailSenderService.sendEmail(emailRequest)).isEqualTo(HttpStatus.OK);
    verify(failService1, times(1)).sendEmail(emailRequest);
    verify(mailService2, times(1)).sendEmail(emailRequest);
  }

  @Test
  public void sendEmail_twoFailServices_BothServicesCalledReturnFail() {
    mailServices.add(failService1);
    mailServices.add(failService2);
    EmailSenderService emailSenderService = new EmailSenderService(mailServices);
    assertThat(emailSenderService.sendEmail(emailRequest)).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
    verify(failService1, times(1)).sendEmail(emailRequest);
    verify(failService2, times(1)).sendEmail(emailRequest);
  }
}
