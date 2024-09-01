
# Library Management System in Java (Incubyte Assessment)

This is a simple library management system entirely implemented using a Test Driven Development (TDD) approach. It allows users to perform basic operations such as adding books, borrowing books, and viewing available books. 

## Table of Contents

- [What is TDD?](#What-is-TDD)
- [How to Setup the Project?](#how-to-setup-the-project)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Running the tests](#running-the-tests)
- [Test Coverage](#test-coverage)
- [How to use?](#how-to-use?)
- [Built with](#built-with)
- [Authors](#authors)

## What is TDD ?

Test-Driven Development (TDD) is a software development approach in which tests are written before the actual code is implemented. The process follows a cyclical pattern known as Red-Green-Refactor:

Red: Write a test for a specific functionality that doesn’t exist yet. Run the test, and it should fail (indicated by the "red" status), as the code to pass the test hasn't been written.

Green: Write the minimal amount of code necessary to pass the test. This is typically quick and simple, just enough to make the test pass (indicated by the "green" status).

Refactor: Clean up the code while ensuring that all tests still pass. Refactoring involves improving the code structure, removing duplications, and enhancing readability without altering the external behavior.

### Benefits of TDD:
  Improved Code Quality: TDD ensures that code is thoroughly tested, leading to fewer bugs and better design.
  Confidence in Code: Developers can confidently make changes, knowing that any regression or issues will be caught by the tests.
  Better Design: Writing tests first forces developers to think about the design and interface of the code, often resulting in a more modular and flexible codebase.
  Documentation: Tests serve as documentation for how the code is supposed to work.
  
### In summary, TDD is a disciplined method of ensuring that software is well-tested, well-designed, and maintainable by writing tests before coding.

## How to Setup the Project?

Follow the below steps to get started with the project running on your system. 

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/in/java/technologies/downloads/) version 11 or later installed
- [IntelleJ Idea](https://www.jetbrains.com/idea/download/?section=windows) installed
- [Maven](https://www.jetbrains.com/help/idea/maven-support.html) installed 

### Installation

#### Download the zip file
  ###
   ![img](https://github.com/user-attachments/assets/a18106eb-5e52-42d0-a9b5-be0bb6d682fa)

- Extract the zip file in your system

- Open the IntelliJ Idea and import the extracted folder

#### Using git clone

- Use git clone command to fork/clone the repository
  ###
  ![img](https://docs.github.com/assets/cb-60499/mw-1440/images/help/repository/https-url-clone-cli.webp)

- Change the current working directory to the location where you want the cloned directory.

- Type git clone, and then paste the URL you copied earlier.

- git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
  
## Running the Tests

- Navigate to the test file
  ```
  src > test > java > org.example > MainTest.java
  ```
- Click the run button to run all the unit tests simultaneously. 

## Test Coverage

The following image shows the test coverage of the project. 
(![image](https://github.com/user-attachments/assets/fec4395b-dbc5-4d84-ad7b-3d44e0725181)

## How to use?

- Navigate to the Main Class
  ```
  src > main > java > org.example > Main.java
  ```
- Object of LibraryManagementClass is created for you. Start using the application by adding new books, borrowing, returning, and viewing the already added books. 


## Built with

- **Programming Language:** [Java](https://www.java.com/en/)

- **Build Tool:** [Maven](https://www.jetbrains.com/help/idea/maven-support.html)

- **Testing Framework:** [JUnit 5](https://junit.org/junit5/)
  
-[![A video on How to use JUnit for unit testing](https://github.com/user-attachments/assets/61a585a3-6fcf-43b2-a493-5228d35246fa)](https://www.youtube.com/watch?v=vZm0lHciFsQ&pp=ygUnd2hhdCBpcyB0ZXN0IGRyaXZlbiBkZXZlbG9wbWVudCBpbiBqYXZh)

## Authors

- [@Hemp04](https://www.github.com/Hemp04)
