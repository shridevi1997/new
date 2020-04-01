Feature: demo web shop login feature

  Scenario Outline: valid login user
    Given the url of the login for demo web shop "http://demowebshop.tricentis.com/login"
    When user enters "<email>" as email
    And user enters "<password>" as password
    And user clicks on login button
    Then user is in shopping page
    #But not in login page

    Examples: 
      | email             | password |
      | askmail@email.com | abc123   |
      | askmail@ymail.com | abc123   |
      | askmail@gmail.com | abc123   |