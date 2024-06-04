Feature: Search Item Functionality with Click on Category
  "As a Customer, I want to Click on a Category
  so that I can view the category window page of related product
  and I can Click on product of this category."

  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible

Scenario: Search Item Functionality with Click on Property Category without any error
  Given I Click on Property Category
  When I should see the category window page of Property product
  Then I click on the Flat for Sale product in this category
  And I select district "Dhaka"
  And I select area of Dhaka "Badda"
  And I click on submit location
  Then I should see search results for "Flat for Sale" in the Sub-Category page
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
    | IsNegotiable      | No            |

  Scenario: Search Item Functionality with Click on Vehicle Category without any error
    Given I Click on Vehicle Category
    When I should see the category window page of Vehicle product
    Then I click on the Car product in this category
    And I select district "Dhaka"
    And I select area of Dhaka "Mohammadpur"
    And I click on submit location
    Then I should see search results for "Car" in the Sub-Category page
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

  Scenario: Search Item Functionality with Click on Electronics Category without any error
    Given I Click on Electronics Category
    When I should see the category window page of Electronics product
    Then I click on the Mobile product in this category
    And I select district "Dhaka"
    And I select area of Dhaka "Banani"
    And I click on submit location
    Then I should see search results for "mobile" in the Sub-Category page
    And  I click on Oppo Reno 6 Used mobile name
    Then I should see the following information in the details of this product
      | name         | value  |
      | Condition    | Used   |
      | Brand        | Oppo   |
      | Model        | Reno 6 |
      | Ram          | 8      |
      | IsNegotiable | No     |
  Scenario: Search Item Functionality with Click on LifeStyle Category without any error
    Given I Click on LifeStyle Category
    When I should see the category window page of LifeStyle product
    Then I click on the Mens Bags or wallets product in this category
    And   I select district "Dhaka"
    And   I select area of Dhaka "Savar"
    And I click on submit location
    Then I should see search results for "Mans Bags" in the Sub-Category page
    And   I click on Mans Bags name
    Then I should see the following information in the details of this product
      | name         | value          |
      | Condition    | New            |
      | ItemType     | Messenger Bags |
      | IsNegotiable | No             |

    @NoShowLocationSelect
  Scenario: Search Item Functionality with Click on Jobs Category without any error
    Given I Click on Jobs Category
    When I should see the category window page of Jobs product
    Then I click on the Accountant product in this category
#    And   I select district "Dhaka"
#    And   I select area of Dhaka "Banasree"
#    And I click on submit location
    Then I should see search results for "Accountant" in the Sub-Category page
    And  I click on Senior Project Accountant name
    Then I should see the following information in the details of this product
      | name              | value           |
      | JobType           | Contractual     |
      | SalaryRange       | 10000 - 30000   |
      | Salary            | Not Negotiable  |
      | ContactEmail      | ba.eran@aol.com |
      | EmployerOrCompany | Envirocon       |