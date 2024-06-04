Feature: Ads Boosting for General User
  As a General user I want to boosting my ads
  So that I can see my ads according to Boosting
  Background:
#    Given I am on the homepage
#    When Satisfy that homepage is visible
#    Given I click on login menu
#    When I click on General user of login menu
#    Then I fill userName "testUser02"
#    And I fill password "sid21@A!"
#    And I click on login submit btn
#    And I should see my profile name "Abu Siddique" in the dashboard
  Scenario: ads boosting functionality
    Given I click on the total active Ads
    When  I should be navigated to the active post page
    Then  I click on Boost your Ad
    And I select Show Up statement
    And I select Between promotion
    And I select Payment By Bundle
    And I should see promotion amount "570" is added correctly
    Then I click on Make payement btn

  Scenario: Check the active ad in the carousel
    Given I am on the homepage
     When  I Click on Jobs Category
    Then I click on all jobs
    And the ad title should be "Junior Accountant002"
    And the ad price should be "BDT 15000-20000"

