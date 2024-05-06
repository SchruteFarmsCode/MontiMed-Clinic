# MontiMed Clinic

MontiMed Clinic is a web application project designed for managing a medical clinic. The application allows for appointment scheduling, patient management, doctor management, and other clinic resources.

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-repository/MontiMed-Clinic.git
   ```

2. Navigate to the project directory:

   ```bash
   cd MontiMed-Clinic
   ```

3. Run the application using Gradle:

   ```bash
   ./gradlew bootRun
   ```

## Usage

1. After starting the application, open a web browser and go to:

   ```
   http://localhost:8080
   ```

2. Log in using your user account.

3. Utilize the application features according to its purpose.

## Configuration

The application uses a PostgreSQL database. Make sure you have the database installed and configured access in the `application.properties` file.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/MontiDB
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
logging.config=classpath:logback.xml
```

## Contributing

If you would like to contribute to the project's development, report bugs, suggest enhancements, or provide support to other users.

## License

This project is licensed under the MIT License. For more information, see the `LICENSE` file.

## Contact

For questions or suggestions regarding the project, please contact us at: szymon.teperek99@o2.pl