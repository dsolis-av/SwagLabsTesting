# Automated Web Testing - Swag Labs

This project is an automated web testing suite developed in Java to validate the [Swag Labs - Sauce Demo website](https://www.saucedemo.com/). It uses TestNG, Selenium Web Driver and the Page Object Model design pattern to enhance the maintainability and reusability of test code, as well as empowering the separation of concerns. The goal is to ensure the correct functionality of the website under different scenarios.

## What It Does

The test suite covers the following scenarios:
- Successful login and logout.
- Purchasing a random product and validating the entire flow until arriving at the successful purchase screen.
- Adding and successfully removing items from the shop cart.

## How to run with IntelliJ

1. Clone the repository.
2. Make sure you have **Java 8+** and **Maven** installed.
3. Navigate to the project root directory.
4. Install dependencies using:
```bash
mvn clean install
```
5. With IntelliJ, open the project and execute each test class to validate scenarios individually, or run the suite.xml file to execute the whole suite.