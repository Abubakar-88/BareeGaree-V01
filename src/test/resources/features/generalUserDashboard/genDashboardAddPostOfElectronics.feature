Feature: Electronics category add posting of subcategory
  As General user I can add posting with the electronics category
  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on General user of login menu
    Then I fill userName "testUser02"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Siddique" in the dashboard
    And I click on post add
    And I click on post add body
    Then I Click on the Electronics Category

  Scenario: Electronics category Mobile add posting functionality
    Given I click on Mobile
    When I fill Title "Oppo6"
    Then I select of Condition "New"
    And I select of Brand "Oppo"
    And I fill of Model "Oppo6"
    And I fill Description "Description1"
    And I fill address "Banani"
    And I fill display size(inch) "6.2"
    And I fill ram "4gb"
    And I fill Processor "TestProcessor"
    And I fill price "20000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\Oppo_Reno8_Pro_1.png  |
      | C:\TestingPicture\mz4hHSCHtJYRPeaC.png |
    And I click on submit button

  Scenario: Electronics category Laptop add posting functionality
    Given I click on Laptops
    When I fill Title "Dell laptop"
    Then I select of Condition "New"
    And I select of Brand "Dell"
    And I fill of Model "dell02"
    And I fill Description "Description1"
    And I fill address "Banani"
    And I fill display size(inch) "6.2"
    And I fill ram "4gb"
    And I fill Processor "TestProcessor"
    And I fill HDD(Hard Drive) "500gb"
    And I fill price "60000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\laptop.jpg  |
      | C:\TestingPicture\laptop.jpg |
    And I click on submit button

  Scenario: Electronics category Computer And Laptop Accessories add posting functionality
    Given I click on Computer And Laptop Accessories
    When I fill Title "Accessories"
    Then I select of Condition "New"
    And I select of Brand "Acer"
    And I select of Item type "Casing"
    And I fill Description "Description1"
    And I fill address "Banani"
    And I fill price "3000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\laptop.jpg  |
      | C:\TestingPicture\laptop.jpg |
    And I click on submit button