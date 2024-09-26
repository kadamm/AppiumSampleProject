# Appium Automation Project

This project is an example of mobile test automation using Appium, Cucumber, and Page Factory.
It includes Cucumber feature files for behavior-driven development (BDD) and generates reports using Cucumber JVM.

## Table of Contents

- Prerequisites
- Installation
- Project Structure
- Running Tests
- Generating Reports

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher
- Maven
- Node.js and npm
- Appium server
- Android Studio or Xcode (for iOS)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/kadamm/AppiumSampleProject.git
    cd AppiumSampleProject
    ```

2. Install the dependencies:
    ```sh
    mvn clean install
    ```

3. Start the Appium server:
    ```sh
    appium
    ```
4. Running Tests
   To run the tests, use the following command:
    ```sh
    mvn test -Dsurefire.suiteXmlFiles=SmokeSuite.xml
    ```

5. Generating Reports

The reports will be generated in the target/cucumber-reports/ directory.