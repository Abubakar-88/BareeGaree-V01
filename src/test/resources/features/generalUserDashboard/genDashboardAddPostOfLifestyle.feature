Feature: Lifestyle category ad posting of subcategory
  As General user I can add posting with the Lifestyle category

  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on General user of login menu
    Then I fill userName "testUser02"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Siddique" in the dashboard


  Scenario: Lifestyle category Health And Beauty ad posting functionality
    And I click on post add
    And I click on post add body
    Then I Click on the Lifestyle Category
    Given I click on Health And Beauty
    When I fill Title "skin001"
    Then I select of Condition "New"
    And I fill Description "Description1"
    And I fill address "Banani"
    And I select of Item type "Skin and Body Care"
    And I fill price "500"
    #And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                      |
      | C:\TestingPicture\skincare.jpg |
      | C:\TestingPicture\skincare.jpg |
    And I click on submit button

  Scenario: Lifestyle category  after ad posting of skin and Body care  preview details functionality
  # Then I click on the dashboard menu
    And I click on the Total pending ads
    And I click on the preview button
    And I should see the following information in preview table with skin and Body care
      | Condition | Item Type          | title   | Description  | Address | Price | district | area   | Phone number | status  |
      | New       | Skin and Body Care | skin001 | Description1 | Banani  | 500   | Dhaka    | Banani | 01548795251  | Pending |








