Feature: addNewAddress

  Scenario Outline: I add new address to my account
    Given I have open browser with with login page on my-store
    When I enter data and click SignIn button
    And I click on add first address
    And I enter data and click save button <alias>, <street>, <postal>, <city>, <country>, <phone>
    Then I added address to my account

    Examples:
      | alias    | street    | postal | city       | country       | phone      |
      | abc      | street 13 | 48-120 | New York   | United Kingdom|  123123123 |


