Feature: DataTable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then  User should login successfully

  Scenario: Create Country
    And Click on the element int the Left Navigation
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | aliCountry1 |
      | codeInput | 213213      |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | aliCountry1 |

    And Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element int the Left Navigation
      | setupOne      |
      | parameters    |
      | nationalities |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | aliCountry123 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | aliCountry123 |

    And Success message should be displayed

  Scenario: Create a Fee and Delete a Fee
    And Click on the element int the Left Navigation
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | merhabaAli |
      | codeInput | 612 |
      | integrationCodeInput | 1787 |
      | priorityInput | 1000 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
      | merhabaAli |

    And Success message should be displayed