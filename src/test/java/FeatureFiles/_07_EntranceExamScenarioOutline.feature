#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption      | GradeLevelOption |
#| Math exam is1   | academicPeriod2              | gradeLevel4  |
#| IT exam is1     | academicPeriod2              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod2              | gradeLevel3  |
#| Math exam  is1  | academicPeriod2              | gradeLevel1  |

Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then  User should login successfully

  Scenario Outline: Create and Delete Exam
    And Click on the element int the Left Navigation
      | entranceExamButton  |
      | setupTwo            |
      | entranceExamButton2 |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriodInput    |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element int the Left Navigation
      | entranceExamButton  |
      | setupTwo            |
      | entranceExamButton2 |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed

    Examples:
      | ExamName        | AcademicPeriodOption | GradeLevelOption |
      | Math exam is4   | academicPeriodInput2 | gradeLevel2      |
      | IT exam is4     | academicPeriodInput2 | gradeLevel2      |
      | Oracle exam is4 | academicPeriodInput2 | gradeLevel2      |
      | Math exam is4   | academicPeriodInput2 | gradeLevel2      |

    #TODO yukarıdaki academic ve Grade Level option için academicPeriodInput2 ve gradeLevel2 bulunup example koyulacak.
