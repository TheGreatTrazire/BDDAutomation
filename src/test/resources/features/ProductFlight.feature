Feature: Create transaction with Virtual Account for domestic round trip with xx transit and login with email
  Scenario: Login with valid email and password
    Given User is on tiket homepage
    Then User goes to login page
    Then User input valid email
    Then User click Lanjutkan button
    Then User input valid password
    Then User click Log in button
    Then User should go to homepage

  Scenario: Create Round Trip Transaction for Flight
    Given User is on tiket homepage
    Then User goes to flight page
    And User choose roundtrip flight
    Then User choose departure city
    And User choose destination city
    Then User choose departure date
    And User choose departure date for back
    Then User choose 1 adult 0 kid 0 infant for passenger
    Then User choose cabin class
    Then User click Cari Penerbangan Button
    When User in search page, verify the page and filter
    Then User choose the flight dep
    And User choose the flight ret
    When User in detail page, enter passenger detail
    Then User choose BCA VA and continue
    And Verify detail payment page (VA Number)
    Then User should go to homepage

  Scenario: Logout Account
    Given User is on tiket homepage
    Then User click account header
    And User click keluar button