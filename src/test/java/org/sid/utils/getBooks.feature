Feature: getBooks
  Background:
    * url baseURL

  Scenario: get Books
    Given path 'books'
    When method GET
    Then status 200