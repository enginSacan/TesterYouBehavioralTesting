Feature:  User can do following actions for pet
  * Create Pet
  * Get    Pet
  * Update Pet
  * Delete Pet

  For each actıon user needs to have an authentıcation from the system.

  Background:
    Given I have an authentication for application

  Scenario Outline: Add a new pet to the pet store
    Given User has a pet with the following details:
      | name   | type   | status   |
      | <name> | <type> | <status> |
    When User add the pet to the store
    Then Store should return response with the following details:
      | name   | type   | status   |
      | <name> | <type> | <status> |
    Examples:
      | name   | type | status    |
      | Fluffy | Dog  | Available |

  Scenario Outline: Delete the added pet from the pet store
    Given User has the added pet information with following details:
      | pet id   |
      | <pet id> |
    When User removes the pet from the store
    Then Store should return response with the following details:
      | pet id   | message   |
      | <pet id> | <message> |
    Examples:
      | pet id | message |
      | 0112   | test    |
