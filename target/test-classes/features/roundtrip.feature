Feature: Round Trip Transaction
  Scenario: Create Round Trip Transaction
    Given User is on tiket homepage
    And User choose roundtrip flight
    Then User choose departure city
    And User choose destination city
    Then User choose departure date
    And User choose departure date for back
    Then User choose xxx adult xxx kid xxx infant for passenger
    Then User choose cabin class
    Then User click Cari Penerbangan Button