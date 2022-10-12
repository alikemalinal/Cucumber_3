Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then  User should login successfully

  Scenario: Create and Delete Exam
    And Click on the element int the Left Navigation
      | entranceExamButton  |
      | setupTwo            |
      | entranceExamButton2 |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | aliExam123 |

    And Click on the element in the Form Content
      | academicPeriodInput  |
      | academicPeriodInput2 |
      | gradeLevel           |
      | gradeLevel2          |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element int the Left Navigation
      | entranceExamButton  |
      | setupTwo            |
      | entranceExamButton2 |

    And User delete item from Dialog
      | aliExam123 |

    Then Success message should be displayed
