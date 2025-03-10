Feature: Test Price API

  Scenario: Obtener el precio aplicable
    Given url 'http://localhost:8080/price'
    And param applicationDate = "2020-06-15T21:00:00"
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response ==
      """
      {
        "brandId": 1,
        "startDate": "2020-06-15T16:00:00Z",
        "endDate": "2020-12-31T23:59:59Z",
        "priceList": 4,
        "productId": 35455,
        "priority": 1,
        "price": 38.95,
        "currency": "EUR"
      }
      """