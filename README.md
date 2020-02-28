# Purpose

UI automated testing framework for https://new.ebanq.com/

# Precondition

* Install Java
* Install Maven
* Install IntelliJ IDEA (preferred IDE)
* Install Lombok plugin for your IDE
* Install Allure commandline https://docs.qameta.io/allure/#_installing_a_commandline
* [Unix only] make chrome executable using command ```chmod +x src/test/resources/webdrivers/chromedriver```

# Tutorials

* Lombok: https://www.baeldung.com/intro-to-project-lombok
* Log4J: https://blog.scalyr.com/2018/08/log4j2-configuration-detailed-guide/
* Hamcrest: http://www.vogella.com/tutorials/Hamcrest/article.html
* Selenide: https://selenide.org/documentation.html

# Technology Stack

* Programming Language: Java https://www.oracle.com/technetwork/java/index.html
* Build Tool with CLI: Maven https://maven.apache.org/
* UI Automation: Selenium https://www.seleniumhq.org/
* Selenide: https://selenide.org/
* Test and assert framework: TestNG and Hamcrest https://testng.org/doc/index.html
* Additional: Lombok, Log4J, Allure Reporting

# GIT strategy

* Master is the main branch

# How to

* ```mvn clean install -DsuiteXmlFile=testng-properties.xml allure:serve``` - to run tests
* ```allure serve target/allure-results``` - to view test report
* ```mvn versions:display-dependency-updates``` - check for latest updated from Maven repo

