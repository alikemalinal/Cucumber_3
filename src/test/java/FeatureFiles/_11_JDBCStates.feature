Feature: Testing JDBC States

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element int the Left Navigation
      | setupOne   |
      | parameters |
      | states     |

    Then Send the query the database "select * from states" and control match