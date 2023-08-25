Feature: Register
  Background:
    * url baseURL

  Scenario: Verify the creation of token after an authentication
    * def clientBody = read('../payload/client.json')
    * path 'api-clients/'
    And request clientBody
    When method POST
    Then status 201

    * def token = response.accessToken
    And match token == "#present"
    * print token