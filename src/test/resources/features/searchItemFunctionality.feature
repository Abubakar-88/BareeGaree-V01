Feature: Search Item functionality
  "As a Customer, I want to search for a product
  so that I can view the search results related to my search."

  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible


  Scenario: Search for items for car in search bar from vehicles Category
    Given I search for "Car" in Search bar
    When  I click the search button
    And I select district "Dhaka"
    And I select area of Dhaka "Mohammadpur"
    And I click on submit location
    Then I should see search results for "Car" in the search page
    And  I click on Toyota Axio car name
    Then I should see the following information in the details of this product
      | name             | value        |
      | Condition        | New          |
      | Brand            | Toyota       |
      | Transmission     | Automatic    |
      | Edition          | 2020         |
      | EngineCapacityCC | 1500         |
      | ManufectureYear  | 2020         |
      | MileageKM        | 1000         |
      | RegistrationYear | 2022         |
      | BodyType         | Coupe/Sports |
      | FuelType         | Diesel       |
      | IsNegotiable     | No           |

  Scenario: Search for items for flat in search bar from Properties Category
    Given I search for "Flat" in Search bar
    When  I click the search button
    And I select district "Dhaka"
    And I select area of Dhaka "Badda"
    And I click on submit location
    Then I should see search results for "flat" in the search page
    And  I click on New readymade flat for sale  property name
    Then I should see the following information in the details of this product
      | name              | value          |
      | NoOfBedroom       | 3              |
      | NoOfBathroom      | 4              |
      | Sizesqft          | 1800           |
      | CarParking        | Yes            |
      | FacingDirection   | North          |
      | CompletionStatus  | Ready          |
      | ApartmentFeatures | Full Furnished |
      | IsNegotiable      | No             |

  Scenario: Search for items for Mobile in search bar from Electronics Category
    Given I search for "Mobile" in Search bar
    When  I click the search button
    And I select district "Dhaka"
    And I select area of Dhaka "Banani"
    And I click on submit location
    Then I should see search results for "mobile" in the search page
    And  I click on Oppo Reno 6 Used mobile name
    Then I should see the following information in the details of this product
      | name         | value  |
      | Condition    | Used   |
      | Brand        | Oppo   |
      | Model        | Reno 6 |
      | Ram          | 8      |
      | IsNegotiable | No     |

  Scenario: Search for items for Mens Bags Or Wallets in search bar from Lifestyle Category
    Given I search for "Bags" in Search bar
    When  I click the search button
    And   I select district "Dhaka"
    And   I select area of Dhaka "Savar"
    And I click on submit location
    Then  I should see search results for "Bags" in the search page
    And   I click on Mans Bags name
    Then  I should see the following information in the details of this product
      | name         | value          |
      | Condition    | New            |
      | ItemType     | Messenger Bags |
      | IsNegotiable | No             |

  Scenario: Search for items for sales Accountant in search bar from Jobs Category
    Given I search for "Accountant" in Search bar
    When  I click the search button
    And   I select district "Dhaka"
    And   I select area of Dhaka "Banasree"
    And I click on submit location
    Then I should see search results for "Accountant" in the search page
    And  I click on Senior Project Accountant name
    Then I should see the following information in the details of this product
      | name              | value           |
      | JobType           | Contractual     |
      | SalaryRange       | 10000 - 30000   |
      | Salary            | Not Negotiable  |
      | ContactEmail      | ba.eran@aol.com |
      | EmployerOrCompany | Envirocon       |

