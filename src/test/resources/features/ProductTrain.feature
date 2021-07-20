Feature: Create transaction with non-instant payment for one-way trip, xx adults and xx infants and select seats
  Scenario: Login with valid email and password
    Given User is on tiket homepage
    Then User goes to login page
    Then User input valid email
    Then User click Lanjutkan button
    Then User input valid password
    Then User click Log in button
    Then User should go to homepage

  Scenario: Create one-way Trip Transaction for Train
    Given User is on tiket homepage
    Then User goes to train page
    Then User choose train departure city
    And User choose train destination city
    Then User choose train departure date
    Then User choose 2 adult 1 infant for passenger
    Then User click Cari Kereta Api Button
    When User in search train page, verify the page and filter
    Then User choose the train dep
    When User in detail page, enter passenger detail
    Then User choose BCA VA and continue
    And Verify detail payment page (VA Number)
    Then User should go to homepage

  Scenario: Logout Account
    Given User is on tiket homepage
    Then User click account header
    And User click keluar button