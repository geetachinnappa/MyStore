Feature: Sign In

  Background:
    Given user navigates to the webiste "http://automationpractice.com/index.php"
    When user clicks on sign in link

  Scenario: Sign In/Login verification 1.Negative scenario required credentials are left blank
    When user logs in through Sign In window by using UserEmail as "" and Password as ""
    Then user should see the error message

  @Test
  Scenario: Sign In/Login verification 2.Negative scenario email is in wrong format
    When user logs in through Sign In window by using UserEmail as "USER" and Password as "1234"
    Then user should see the error message

  Scenario: Sign In/Login verification 3.Negative scenario email is in correct format xyx@x.com but password is blank
    When user logs in through Sign In window by using UserEmail as "user@123.com" and Password as ""
    Then user should see the error message

  Scenario Outline: Sign In/Login verification 4.Positive scenario required credentials are provided
    When user logs in through Sign In window by using UserEmail as "<user>" and Password as "<password>"
    Then user is signed in successfully

    Examples:
    |   user              |   password  |
    |   user@123.com      |   userabc   |
    |   user1@123.com     |   user1abc  |


