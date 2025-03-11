Feature: Test Price API

  Scenario: Obtener el precio aplicable
    Given url 'http://localhost:8080/price'
    And param applicationDate = "2020-06-15T10:00:00"
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response ==
      """
      {
        "brandId": 1,
        "startDate": "2020-06-15T00:00:00Z",
        "endDate": "2020-06-15T11:00:00Z",
        "priceList": 3,
        "productId": 35455,
        "priority": 1,
        "price": 30.5,
        "currency": "EUR"
      }
      """