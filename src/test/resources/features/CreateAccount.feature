Feature: Create An Account

  Background:
    Given user navigates to the webiste "http://automationpractice.com/index.php"
    When user clicks on sign in link

  @Negative
  Scenario: Create Account verification 1. Negative scenario - click on create account without providing valid email address
    And user clicks on create an account button
    Then user should see the create account error message


  @Negative
  Scenario: Create Account verification 2. Negative scenario - click on create account by providing invalid email address
    And user enters email "user"
    And user clicks on create an account button
    Then user should see the create account error message


  @Negative
  Scenario: Create Account verification 3. Negative scenario - click on create account by providing valid email address(account already exists)
    And user enters email "user@123.com"
    And user clicks on create an account button
    Then user should see the create account error message


  @Negative_1
  Scenario: Register Account verification 4. Negative scenario - click on register without providing required credentials
    And user enters email "user1@123.com"
    And user clicks on create an account button
    Then user should be taken to Create An Account page "CREATE AN ACCOUNT"
    When user clicks on register
    Then user should see the create account validation error message

  @Positive_1
  Scenario: Create Account verification 5. Positive scenario - click on create account by providing valid email address
    And user enters email "user1@123.com"
    And user clicks on create an account button
    Then user should be taken to Create An Account page "CREATE AN ACCOUNT"
    When user enters valid data on the page
      | title         | 1              |
      | firstName     | Jack           |
      | lastName      | Wills          |
      | email         | user1@123.com  |
      | password      | user123        |
      | day           | 1              |
      | month         | 4              |
      | year          | 1989           |
      | Address_fname | Jack           |
      | Address_lname | Wills          |
      | Address_line1 | 1, uptown road |
      | city          | New Jersey     |
      | state         | New York       |
      | zipcode       | 12345          |
      | country       | 21             |
      | mobile        | 1234567890     |
      | alias         | HomeAddress    |
    #And user clicks on register
