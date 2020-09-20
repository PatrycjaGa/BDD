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
      Then I get "<price>" PLN for "<eventTime>" hr protection cost

      Examples:
      Decision table for SuperSecurity class
        | eventSize | eventRisk | price  | eventTime |
        | small     | low       | 200    | 1         |
        | small     | high      | 600    | 1         |
        | normal    | low       | 400    | 1         |
        | normal    | high      | 1200   | 1         |
        | big       | low       | 2000   | 1         |
        | big       | high      | 6000   | 1         |
        | small     | low       | 400    | 2         |
        | small     | high      | 1200   | 2         |
        | normal    | low       | 800    | 2         |
        | normal    | high      | 2400   | 2         |
        | big       | low       | 4000   | 2         |
        | big       | high      | 12000  | 2         |
        | small     | low       | 600    | 3         |
        | small     | high      | 2400   | 4         |
        | normal    | low       | 2000   | 5         |
        | normal    | high      | 7200   | 6         |
        | big       | low       | 230000 | 115       |
        | big       | high      | 0      | -1        |

    # Koniec: To zmienilem w 1 ćwiczeniu

# TASK 1: Implement above Scenario as a Scenario Outline for the whole decision table


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

# TASK 2: Above scenario fails due to improper calculation of price in EventHallRental class. Fix it.


# zad1 dla chetnych
  Rule: Bad rental costs
    Scenario: Renting band for event
      Given There is "Korona Nocnego Kochanka" band
      Then I get 360 PLN for 1 hr band time play

    Scenario Outline: Scenario Outline
      Given There is "Korona Nocnego Kochanka" band
      Then I get <price> PLN for <time> hr band time play

      Examples:
        | price | time |
        | 360   | 1    |
        | 720   | 2    |
        | 1080  | 3    |
        | 3600  | 10   |
        | 7200  | 20   |
