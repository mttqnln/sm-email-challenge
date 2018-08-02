# sm-email-challenge

#### Building the project ####
The project is built with gradle wrapper.

https://docs.gradle.org/current/userguide/gradle_wrapper.html

#### Configuring the project ####

This project currently uses two email service providers. The services are `MailJetService` and `SendGridService`. The services expect authentication variables which must be provisioned in the environment. Below are the expected environment variables

##### SendGrid #####
`SEND_GRID_KEY` = the API key provided by SendGrid

##### MailJet #####
`MAIL_JET_AUTH` = the basic auth details provided by MailJet in the format `publicKey:privateKey`

#### Running the project ####

`java -jar build/libs/sm-email-challenge-0.1.0.jar`

The embedded server will be available on http://localhost:8080

To send an email `POST` a request to /email/send. The body should contain the following format and have a content-type of application/json. The cc and bcc fields are not required and can be omitted.

 ```json
{
	"to": ["email1@example.com", "email2@example.com"],
	"cc": [],
	"bcc": [],
	"from": "fromemail@example.com",
	"subject": "example subject",
	"content": "Hello World!"
}
```

#### Live Demo ####

A live demo  is hosted on Heroku. The endpoint (`POST`) can be found here - https://sm-email-challenge.herokuapp.com/email/send

#### Adding/Ordering Mail Services ####

Extra mail services can automatically be added by implementing the `MailService` interface

A mail service can be prioritised by specifying the `@Order` value



