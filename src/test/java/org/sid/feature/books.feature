Feature: Test API BOOKS

  Background:
      * url baseURL
      * def registerFeature = callonce read('../feature/register.feature')
      * def getBooksFeature = callonce read('../utils/getBooks.feature')

  Scenario Outline: Get books by types : <type>
    Given path 'books'
    And param type = <type>
    When method GET
    Then status 200
    Examples:
      |read('../utils/typeBooks.csv')|


  @Valid
  Scenario: Successful authentication creation of an order with an available book
    * def availableBooks = karate.filter(getBooksFeature.response, function(book){ return book.available })
    * def availableBooksMapping = karate.map(availableBooks, function(x){ return x.id })
    * def bookId = availableBooksMapping[0]

    Given path 'orders/'
      And header Authorization = 'Bearer ' + registerFeature.response.accessToken
      And def orderWithAvailableBookPayload = read('../payload/orderBook.json')
      And request orderWithAvailableBookPayload
      When method POST
      Then status 201

  @Valid
  Scenario: Unsuccessful authentication creation of an order
    * def unavailableBooks = karate.filter(getBooksFeature.response, function(book){ return !book.available })
    * def unavailableBooksMapping = karate.map(unavailableBooks, function(x){ return x.id })
    * def bookId = unavailableBooksMapping[0]

      Given path 'orders/'
      And header Authorization = 'Bearer ' + registerFeature.response.accessToken
      And def orderWithUnavailableBookPayload = read('../payload/orderBook.json')
      And request orderWithUnavailableBookPayload

      When method POST
      Then status 404
      And print 'UnSuccessful authentication creation of an order'





