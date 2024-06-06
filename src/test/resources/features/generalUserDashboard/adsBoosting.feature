Feature: Ads Boosting for General User
  As a General user I want to boosting my ads
  So that I can see my ads according to Boosting
  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on General user of login menu
    Then I fill email "testUser02"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Siddique" in the dashboard

    Scenario: Edit active ads before boosting
      ""**As a general user If I need Edit
         I can edit without error**""
      Given I click on the total active Ads
      When  I should be navigated to the active post page
      Then I click on the edit
      And I fill Description Requirement "Description4"
      And I fill address "Banani1"
      And I click on update btn
      Then I am on the admin login page
      And I fill userName "admin@gmail.com"
      And I fill password "@Bgca01##@"
      And I click on admin login submit btn
      And I hover on the Repending post
      And I click on the RePending job
      And I click on the Preview link for update Repending post "Junior Accountant002"
      And I want to select post status "Active"
      Then I click on pending post update btn



    @GeneralUserDashboard @regression
  Scenario: ads boosting functionality
    Given I click on the total active Ads
    When  I should be navigated to the active post page
    Then  I click on Boost your Ad
    And I select Show Up statement
    And I select Between promotion
    And I select 5 Day
    And I click on Continue btn
    And I select Payment By Bundle
    And I should see promotion amount "570" is added correctly
    Then I click on Make payment btn

  @GeneralUserDashboard @regression
  Scenario: Check the active ad in the carousel
    Given I am on the homepage
     When  I Click on Jobs Category
    Then I click on all jobs
    And the ad title should be "Junior Accountant002"
    And the ad price should be "BDT 15000-20000"

