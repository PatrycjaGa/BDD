Feature: Event Calculator

  The tool for cost calculations, provided with selected cost components (cost calculators for security, hall rental,
  etc.), should calculate the overall cost of event organization.

# TASK 4: Create Background section
  Background: Negotiate costs
    Given I am negotiating with "Carnegie Hall" event hall provider
    And I am negotiating with "Blue Dragon" security agency

  Rule: Overall costs without profit

    Scenario: High risk big event
      When I want to organize Wrestling Game large event
      Then I get 21000 PLN event cost

    Scenario: Low risk small cameral concert
      When I want to organize cameral concert
      Then I get 560 PLN event cost

    Scenario: Medium risk local football game
      When I want to organize local football game
      Then I get 2800 PLN event cost


    Scenario Outline: Generating summary cost
      When I want to organize "<eventSize>"  event with "<eventRisk>" risk with duration <eventTime> hours
      Then I get <price> PLN event cost
      Examples:
      Decision table for summary cost
        | eventSize | eventRisk | price  | eventTime |
        | small     | low       | 560    | 2         |
        | small     | high      | 2720   | 4         |
        | normal    | low       | 3000   | 5         |
        | normal    | high      | 8400   | 6         |
        | big       | low       | 345000 | 115       |
        | big       | high      | 0      | -1        |

# TASK 5: Add one or more additional scenarios for different events

  Rule: Single ticket price calculations

    Scenario: Low risk small cameral concert
      When I want to organize cameral concert
      And I expect 30 participants
      Then I get 19 PLN for single ticket to cover cost

  Rule: Single ticket price with distribution costs calculation

      Scenario: High risk big music festival
        When I want to organize big music festival
        And  I expect 1000 participants
        Then I get 70 PLN for single ticket with 10 PLN distribution to cover cost