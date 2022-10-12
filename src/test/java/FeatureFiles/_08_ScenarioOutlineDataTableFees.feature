#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then  User should login successfully

  Scenario Outline: Create a Fee and Delete a Fee
    And Click on the element int the Left Navigation
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput            | <nameInput>            |
      | codeInput            | <codeInput>            |
      | integrationCodeInput | <integrationCodeInput> |
      | priorityInput        | <priorityInput>        |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | <nameInput> |

    And Success message should be displayed

    Examples:
      | nameInput   | codeInput | integrationCodeInput | priorityInput |
      | merhabaAli2 | 612       | 1787                 | 10001         |
      | helloThere  | 3213      | 4214                 | 76876         |
      | Ankara06    | 7567      | 4536                 | 4354          |
      | istanbul321 | 32423     | 956                  | 1111          |