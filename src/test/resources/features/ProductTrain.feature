Feature: Create transaction with non-instant payment for one-way trip, xx adults and xx infants and select seats
  Scenario: Login with valid email and password
    Given User is on tiket homepage
    Then User goes to login page
    Then User input valid email
    Then User click Lanjutkan button
    Then User input valid password
    Then User click Log in button
    Then User should go to homepage

    Scenario: