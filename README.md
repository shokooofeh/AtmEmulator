# ATM Emulator

ATM is a part of our life activity, which helps us in day transactions and business. An automated teller machine (ATM) is a computerized telecommunications instrument that provides the clients of a financial institution with access to financial transactions in a public space without the need for a cashier, human clerk or bank teller.

At this time, the ATM provides the people good services especially the people can get money at any time. We need the ATM system because not all the bank branches are open all days of the week, and some of the customers may not in a situation, they can visit the bank every time, and they want to withdraw money or deposit money for emergency cases.


**ATM SPECIFICATIONS:**

The main components of the ATM that will affect the interaction between ATM and its users are:
1.	Card-Reader: to read the users ATM-cards (magnetic stripe reader).
2.	Screen: to display the messages to the users.
3.	Cash-Dispenser: for dispensing cash.
4.	Communication/Network Infrastructure: it is assumed that the ATM has a communication infrastructure to communicate with the bank upon any transaction or activity.

Implement and design the ATM system. It will act as a “second person” that a customer can “talk to”; the customer makes choices that ATM replies back accordingly.




**Environment:**
- Java, Spring Boot, Spring Web, Spring Security, MVC
- JavaScript, jQuery, HTML, CSS, Thymeleaf
- JPA, Hibernate
- MySQL, MySQL Java Connector
- Git, Maven, Spring Boot DevTools
- Swagger UI

**Run Locally:**
1. Install Java 8, MySQL 5.5+, and a Java IDE (this project used IntelliJ IDEA).
2. Configure MySQL with username `root` and password `admin123`. This project assumes that these are
the login credentials for MySQL. Alternatively, if you want to use different credentials, be sure to
change `spring.datasource.username` and `spring.datasource.password` in `src/main/resources/application.properties` as needed.
3. Start the MySQL server, and run the `atm.sql` script (located in this directory). The script
creates a database called `atm` with tables `users` and `accounts` prefilled with information.
4. In your IDE, build the project with Maven 3.3+, and then run
`src/main/java/com/egs/AtmEmulatorApplication.java`. This will start the web app.
5. Navigate to `http://localhost:8080/app/login` in your web browser. Card numbers can be found starting
from line 17 of the `atm.sql` file, and their associated PINs are in comments at the end of the respective
line. For example, card number `378282246310005` has PIN `123`.
6. That's it! Play around with the app, and see the changes updated in your MySQL database.
7. Swagger Documentation: navigate to below address
http://localhost:8080/swagger-ui.html#/