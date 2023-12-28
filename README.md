# EmailSendApi
EmailSendApi is a Spring Boot application for sending emails, including support for attachments. It provides RESTful endpoints for sending both simple and attachment-containing emails.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Logging](#logging)
- [Contributing](#contributing)
- [License](#license)

## Features
- Send simple emails
- Send emails with attachments
- Easy integration with Spring Boot applications
- Logging for better troubleshooting

## Prerequisites
- Java 8 or higher
- Maven
- SMTP server details (for sending emails)

## Getting Started
1. Clone the repository:
   git clone https://github.com/Ajit1702/EmailSendApi.git
   cd EmailSendApi

2. Build the project:
   mvn clean install

3. Run the application:
   java -jar target/EmailSendApi-1.0.jar

## Configuration
Make sure to configure the SMTP server details in your `application.properties` or `application.yml` file. Additionally, you may configure logging levels based on your needs.

Example `application.properties`:
# SMTP Configuration
spring.mail.host=your-smtp-server
spring.mail.port=587
spring.mail.username=your-smtp-username
spring.mail.password=your-smtp-password
spring.mail.properties.mail.smtp.starttls.enable=true

## Usage

### Test Endpoint
Visit `http://localhost:8080/test` in your browser or use tools like curl or Postman to test the application's functionality.

### Send Simple Email
Use the `/sendEmail` endpoint with a POST request and provide the necessary JSON payload:

{
  "to": "recipient@example.com",
  "subject": "Hello",
  "msg": "This is a test email."
}

### Send Email With Attachment
Use the `/sendEmailWithAttachment` endpoint with a POST request and provide the necessary JSON payload:

{
  "to": "recipient@example.com",
  "subject": "Hello with Attachment",
  "msg": "This email contains an attachment.",
  "attachment": "/path/to/your/attachment.txt"
}

## Logging
The application uses SLF4J logging. Adjust the log levels in your `application.properties` to control the amount of logging:

# Log level
logging.level.com.example = INFO

## Contributing
Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

## License
This project is licensed under the [MIT License](LICENSE).

Make sure to replace placeholders like `Ajit1702` with your actual GitHub username, and update any other details as needed.
