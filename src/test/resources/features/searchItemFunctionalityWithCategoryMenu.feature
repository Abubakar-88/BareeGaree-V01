Feature: Search Item Functionality with on Category Menu
  "As a Customer, I want to Hover on a Category
  so that I can view the product name of related Category
  and I can Click on product of this category."

  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Then I hover on category menu

  Scenario:  Search Item Functionality on Category Menu so I can select Property related product
    Given I hover on the Property category
    When I click on the Flat for Sale product in menu category
    Then I should see search results for "Flat for Sale" in the Sub-Category page
    Then  I click on New readymade flat for sale  property name
    And I should see the following information in the details of this product
      | name              | value          |
      | NoOfBedroom       | 3              |
      | NoOfBathroom      | 4              |
      | Sizesqft          | 1800           |
      | CarParking        | Yes            |
      | FacingDirection   | North          |
      | CompletionStatus  | Ready          |
      | ApartmentFeatures | Full Furnished |
      | IsNegotiable      | No            |

  Scenario:  Search Item Functionality on Category Menu so I can select Vehicle related product
    Given I hover on the Vehicle category
    When I click on the Car product in this menu category
    Then I should see search results for "car" in the Sub-Category page
    Then  I click on Toyota Axio car name
    And I should see the following information in the details of this product
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

  Scenario:  Search Item Functionality on Category Menu so I can select Electronics related product
    Given I hover on the Electronics category
    When I click on the Mobile product in this menu category
    Then I should see search results for "mobile" in the Sub-Category page
    And  I click on Oppo Reno 6 Used mobile name
    Then I should see the following information in the details of this product
      | name         | value  |
      | Condition    | Used   |
      | Brand        | Oppo   |
      | Model        | Reno 6 |
      | Ram          | 8      |
      | IsNegotiable | No     |

  Scenario:  Search Item Functionality on Category Menu so I can select LifeStyle related product
    Given I hover on the LifeStyle category
    When I click on the Mens Bags or wallets product in this menu category
    Then I should see search results for "Mans Bags" in the Sub-Category page
    And   I click on Mans Bags name
    Then  I should see the following information in the details of this product
      | name         | value          |
      | Condition    | New            |
      | ItemType     | Messenger Bags |
      | IsNegotiable | No             |

  Scenario:  Search Item Functionality on Category Menu so I can select Jobs related product
    Given I hover on the Jobs category
    Then I click on the Accountant product in this menu category
    And  I click on Senior Project Accountant name
    Then I should see search results for "Accountant" in the Sub-Category page
    Then I should see the following information in the details of this product
      | name              | value           |
      | JobType           | Contractual     |
      | SalaryRange       | 10000 - 30000   |
      | Salary            | Not Negotiable  |
      | ContactEmail      | ba.eran@aol.com |
      | EmployerOrCompany | Envirocon       |