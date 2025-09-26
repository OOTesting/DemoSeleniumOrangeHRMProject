# Demo Selenium Automation Project for OrangeHRM

This repository contains a Selenium-based automation framework developed to conduct end-to-end UI testing.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Running the Tests](#running-the-tests)
- [Test Reporting](#test-reporting)



## Introduction

This project aims to automate some of the user interface tests on the OrangeHRM website 

## Features

- **End-to-End UI Testing**: Test coverage for various functionalities of the OrangeHRM website. It should be noted, this is evoling and will change over time]
- **Selenium WebDriver**: Utilized for interacting with the web elements and performing actions.
- **TestNG**: Employed for organizing and managing test cases, providing powerful annotations and reporting capabilities.
- **Allure Reports**: Integrated to generate detailed and visually appealing reports of the test execution.

## Technologies Used

- **Java**: Programming language used for developing the test scripts [Used JDK 21 in this project]
- **Selenium WebDriver**: Tool for automating web application testing.
- **TestNG**: Testing framework for structuring and running tests.
- **Allure Reports**: Library for generating test execution reports.

## Setup and Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/OOTesting/DemoSeleniumOrangeHRMProject.git
   ```
2. **Install Dependencies**

   Ensure you have the following installed:

    - Java Development Kit (JDK) [I'm using JDK 21]
    - Apache Maven

   Install Maven dependencies:

   ```bash
   mvn clean install
   ```

## Running the Tests

To execute the tests, use the following Maven command:

```bash
mvn test

OR

mvn clean test -Dtest=LoginPositiveTest  [Single test case]
```


```bash
allure open target/allure-report [Run after test run]
```

This command will compile the test classes and run the TestNG test suite defined in the testng.xml file.

## Test Reporting

The project uses Allure Reports to generate detailed and visually appealing test reports. 
After running the tests, the report will be generated in the allure-report directory.

# Accessing the Report

1. Navigate to the allure-report directory or wait until the webserver and the report is displayed
2. Open the Allure HTML report file in a web browser to view the test results.

The report includes detailed information about each test, including the steps executed, the status (pass/fail), and any screenshots captured during the test execution.


