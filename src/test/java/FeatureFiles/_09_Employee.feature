#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.

Feature: Employee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then  User should login successfully

  Scenario Outline: Create a Employee and Delete a Employee

    And Click on the element int the Left Navigation
      | humanResourcesButton |
      | employeesButton      |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | firstName | <firstNameInput> |
      | lastName  | <lastNameInput>  |

    And Click on the element in the Form Content
      | gender          |
      | <gender2>       |
      | employeeType    |
      | <employeeType2> |

    And User sending the keys in Dialog content
      | employeeIdInput | <employeeIdInput> |

    And Click on the element in the Form Content
      | qualification    |
      | <qualification2> |
    
    Examples:
      | firstNameInput | lastNameInput | gender2 | employeeType2 | employeeIdInput | qualification2 |
      | cucumber       | java          | gender2 | employeeType2 | 1002            | qualification2 |


