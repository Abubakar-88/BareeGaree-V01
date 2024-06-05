Feature: Jobs category add posting of subcategory
  As General user I can add posting with the Job category
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
    Then I Click on the Jobs Category

  @GeneralUserDashboard @regression
  Scenario: Jobs category Accountant add posting functionality
    Given I click on Accountant
    When I fill Title "Junior Accountant"
    Then I select of Job type "Full Time"
    And I fill Description Requirement "Description1"
    And I fill address "Banani"
    And I fill contact phone number "01548795251"
    And I fill contact email "test@gmail.com"
    And I fill salary from "15000"
    And I fill salary to "20000"
    And I click on Negotiable check btn
    And I fill company name "Test company"
    And I choose company logo
      | imagePath                        |
      |C:\TestingPicture\companylogo.png  |
    And I pick application deadline "31"
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I click on submit button
