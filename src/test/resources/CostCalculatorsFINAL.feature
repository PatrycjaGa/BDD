Feature: Cost calculators

  For the event cost there are several cost components, i.e. event hall rental, security, etc. These tests
  contains scenarios for different classes calculating particular costs separately

  Rule: Security costs


    Scenario: Small event, low risk
      Given There is "Blue Dragon" security agency
      When The event size is "small"
      And The event risk is "low"
      Then I get 200 PLN for 1 hr protection cost


# TASK 1: Implement above Scenario as a Scenario Outline for the whole decision table
    Scenario Outline: Scenario outline
      Given There is "Blue Dragon" security agency
      When The event size is "<eventSize>"
      And The event risk is "<eventRisk>"
      Then I get <pricePerHour> PLN for 1 hr protection cost

      Examples:
      Decision table for SuperSecurity class
        | eventSize | eventRisk | pricePerHour |
        | small     | low       | 200          |
        | small     | high      | 600          |
        | normal    | low       | 400          |
        | normal    | high      | 1200         |
        | big       | low       | 2000         |
        | big       | high      | 6000         |


# TASK 3: Analogically to scenario "Renting small room for 2h event" write a scenario to more than 1h security cost

  Rule: Room rental costs

    Scenario: Renting normal room for 1h event
      Given There is "Carnegie Hall" event hall agency
      When The event size is "normal"
      Then I get 200 PLN for 1 hr room rental price

    Scenario: Renting small room for 2h event
      Given There is "Carnegie Hall" event hall agency
      When The event size is "small"
      Then I get 160 PLN for 2 hrs room rental price

    Scenario: Renting small room for 2h event
      Given There is "Carnegie Hall" event hall agency
      When The event size is "small"
      Then I get 160 PLN for 2 hrs room rental price

# wprowadzone zmiany, w getcost bierze pod uwage ze przy big min 5h, inaczej zero
    Scenario: Renting big room for 2h event
      Given There is "Carnegie Hall" event hall agency
      When The event size is "big"
      Then I get 5000 PLN for 5 hrs room rental price

    Scenario: Renting big room for 2h event
      Given There is "Carnegie Hall" event hall agency
      When The event size is "big"
      Then I get 0 PLN for 4 hrs room rental price


# TASK 2: Above scenario fails due to improper calculation of price in EventHallRental class. Fix it.
