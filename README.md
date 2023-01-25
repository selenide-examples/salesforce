# salesforce
Demonstration how to test Salesforce applications

## How to run tests

To run tests, just type the following command in command line:

```bash
ant -Dsalesforce.username=your-username@developer.salesforce.com -Dsalesforce.password=your-password
```

This command can be run either by your or your CI server (like Jenkins or Bamboo).

## Prerequisites

You only need to have Java, Ant and Chrome installed on your computer to run these tests.

## Browser configuration

Selenide tests are run in Chrome by default.

To run UI tests with different browser, just add this parameter to command line:

 * `ant -Dselenide.browser=chrome`
 * `ant -Dselenide.browser=phantomjs`
 * `ant -Dselenide.browser=htmlunit`

P.S. To use some of these browsers, you need to install corresponding 
binary (e.g. chromedriver, phantomjs) or dependencies (e.g. htmlunit, phantomjs).