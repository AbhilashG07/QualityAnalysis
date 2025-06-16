Project:- QualityAnalysis

Overview:
This is an example BDD test automation project for running tests on Bank website using the Cucumber-JVM framework. It contains a simple behavior driven scenarios that performs testing on Bank website features.

Installation:
JAVA as the programming language for writing test code
Cucumber as the framework
Maven as the build tool
IntelliJ as the preferred IDE for writing java code
Add TestNG, JUnit and Cucumber plugin to IntelliJ.

Setup:
Install JDK 1.8
Install IntelliJ (Community edition should suffice)
Install Maven

Running tests:
Run tests from command line: Have created profiles in pom file, choose appropriate profile to run tests.
    For running smoke tests use command: mvn integration-test -Psmoke
    For running sanity tests use command: mvn integration-test -Psanity
    For running regression tests use command: mvn integration-test -Pregression
    For running a test case with particular tag name use command: mvn integration-test "-Dcucumber.filter.tags=@homepage" 
    For running default test cases use command: mvn integration-test

Setting browser type in framework.properties file:
    For running tests in Chrome browser set "browser=chrome"
    For running tests in IE browser set "browser=ie"

Test Results:
Open ExtentSpark.html file in any web browser to see the test results.

TODO: Logger configuration is not added for this project as it was not mentioned in the assignment case study.
    