Feature: getBook
  Scenario: get books with parametric id
    Given url baseURL
    And path 'books' , id
    When method GET
    Then status 200
