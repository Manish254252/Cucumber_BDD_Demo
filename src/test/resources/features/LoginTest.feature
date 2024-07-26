Feature: Testing LoginPage

  @smoke
  Scenario: Login using username and password
    Given If the user is on Login Page
    When User enters user and password and clicks login
    Then user should go to HomePage

  Scenario: Logout
    Given If the user is on Home Page
    When User Clicks on logout button
    Then user should go to LoginPage