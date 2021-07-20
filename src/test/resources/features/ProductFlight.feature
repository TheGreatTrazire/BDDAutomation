Feature: Create transaction with Virtual Account for domestic round trip with xx transit and login with email
#  Scenario: Login with valid email and password
#    Given User is on tiket homepage
#    Then User goes to login page
#    Then User input valid email
#    Then User click Lanjutkan button
#    Then User input valid password
#    Then User click Log in button
#    Then User should go to homepage

  Scenario: Create Round Trip Transaction for Flight
    Given User is on tiket homepage
    Then User goes to flight page
    And User choose roundtrip flight
    Then User choose departure city
    And User choose destination city
    Then User choose departure date
    And User choose departure date for back
    Then User choose xxx adult xxx kid xxx infant for passenger
    Then User choose cabin class
    Then User click Cari Penerbangan Button
    Then User should go to homepage