# MiTTPP_frontend-testing

This is a student project for frontend website testing. The project contains a framework setup that can be used for testing the website [HGSPOT](https://www.hgspot.hr/).

## Content

This repository contains a Kotlin project managed by Gradle. IntelliJ IDEA was used to create the project and execute the tests. The TestNG library is used to execute the tests. Browser automation is done with Selenium.

The included tests are split into three categories:
- Cart tests - tests related to the shopping cart
- Results tests - related to article results pages
- Generic tests - other tests

### Cart tests

- Adding article to cart
- Removing article from cart
- Modifying article amount

### Results tests

- Accessing category page from home page
- Correctness and changing of sorting by price

### Generic tests

- Searching for articles
- Accessing featured articles from home page

---

The pool of tests can be easily expanded by adding new tests to the already existing test classes or by adding them to new classes. The superclass of all provided tests is `HgShopTests`. It handles setting up web drivers for different browsers prior to test execution. It is recommended that all test classes extend it. The tests can then be written without worrying about setting up the web driver for any specific browser.

By default, the supported browsers are Chrome, Firefox and Edge. All browsers used in testing need to be installed on the machine running the tests. Setting up the drivers for the browsers is done using `WebDriverManager`.

The `testng.xml` file, located in the resources folder of the test module, is where browser and test configuration is set up. Each browser that should be tested on needs to be declared in a separate test section as a parameter with the name `browser`. The `HgShopTests` class reads that parameter and sets up the appropriate browsers depending on the value. Any new browsers that need to be supported have to be properly handled in `HgShopTests`.

The project maintains a page object model of the website for more reliable testing.

### Test reports

TestNG and Gradle automatically generate test reports when tests are running. All generated reports are placed in the `TestReports` directory under the project root. For demonstation purposes, a sample set of reports has been included in the repository under the `SampleTestReports` directory.

## Setup

The fastest way to set up the project and start testing is to clone this repository with IntelliJ IDEA and execute the Gradle task `test` under `verification`. If all three initially supported browsers are installed on your system, the tests should start executing. The results will be visible directly in the IDE as well as in the generated test reports folder.
