Feature: Event Calculator

  The tool for cost calculations, provided with selected cost components (cost calculators for security, hall rental,
  etc.), should calculate the overall cost of event organization.

# TASK 4: Create Background section

  Rule: Overall costs without profit

    Scenario: High risk big event
      Given I am negotiating with "Carnegie Hall" event hall provider
      And I am negotiating with "Blue Dragon" security agency
      When I want to organize Wrestling Game large event
      Then I get 21000 PLN event cost

    Scenario: Low risk small cameral concert
      Given I am negotiating with "Carnegie Hall" event hall provider
      And I am negotiating with "Blue Dragon" security agency
      When I want to organize cameral concert
      Then I get 560 PLN event cost

# TASK 5: Add one or more additional scenarios for different events

  Rule: Single ticket price calculations

      Scenario: Low risk small cameral concert
        Given I am negotiating with "Carnegie Hall" event hall provider
        And I am negotiating with "Blue Dragon" security agency
        When I want to organize cameral concert
        And I expect 30 participants
        Then I get 19 PLN for single ticket to cover cost