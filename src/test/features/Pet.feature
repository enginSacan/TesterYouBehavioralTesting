Feature:  User can do following actions for pet
  * Create Pet
  * Get    Pet
  * Update Pet
  * Delete Pet

  For each actıon user needs to have an authentıcation from the system.

#  Background:
#    Given I have an authentication for application

  Scenario Outline: Add a new pet to the pet store
    When User added a pet with the following details:
      | id    | name   | type   | status   |
      | <id> | <name> | <type> | <status> |
    Then Store should return response with the following details:
      | id     | name   | type   | status   |
      | <id> | <name> | <type> | <status> |
    Examples:
      | id      | name   | type | status    |
      | 999999 | HawHaw | Dog  | Available |
      | 999998 | Mieaw  | Cat  | Available |

  Scenario Outline: Delete the added pet from the pet store
    Given User has the added pet information with following details:
      | id    | name   | type   | status   |
      | <id> | <name> | <type> | <status> |
    When User removes the pet from the store
    Then Store should delete pet with the following details:
      | id   | message   |
      | <id> | <message> |
    Examples:
      | id     | name   | type | status    | message |
      | 111111 | HawHaw | Dog  | Available | test    |
      | 111112 | Mieaw  | Cat  | Available | test    |
