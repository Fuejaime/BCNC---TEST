Feature: Test Price API

  Scenario: Obtener el precio aplicable
    Given url 'http://localhost:8080/price'
    And param applicationDate = "2020-06-14T16:00:00"
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response ==
      """
      {
        "brandId": 1,
        "startDate": "2020-06-14T15:00:00Z",
        "endDate": "2020-06-14T18:30:00Z",
        "priceList": 2,
        "productId": 35455,
        "priority": 1,
        "price": 25.45,
        "currency": "EUR"
      }
      """