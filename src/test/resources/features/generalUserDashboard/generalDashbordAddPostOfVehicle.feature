Feature: Vehicle category add posting of subcategory
  As General user I can add posting with the vehicle category

  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on General user of login menu
    Then I fill email "testUser02"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Siddique" in the dashboard
    And I click on post add
    And I click on post add body
    Then I Click on the Vehicle Category

  @GeneralUserDashboard @regression
  Scenario: Vehicle category Bicycle add posting functionality
    Given I click on Bicycle
    When I fill Title "Bicycle 002"
    Then I select of Condition "New"
     And I select of Brand "Core"
    And I fill Description "Description1"
    And I fill address "Badda"
    And I fill price "100000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\bycycle-977.jpg  |
      | C:\TestingPicture\bicycle02.jpg |
    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: Vehicle category Motorbike add posting functionality
    Given I click on Motorbike
    When I fill Title "Motorbike 002"
    Then I select of Condition "New"
    And I select of Brand "Bajaj"
    And I select of Model "Pulsar"
    And I fill Description "Description1"
    And I fill address "Badda"
    And I select of Bike type "Motorcycle"
    And I fill Edition "test"
    And I fill Engine Capacity(CC) "150"
    And I fill Manufacture Year "2022"
    And I fill Mileage(KM) "100"
    And I fill price "100000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\bajaj-pulsar-150-new1.jpg  |
      | C:\TestingPicture\hqdefault.jpg |
    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: Vehicle category Car add posting functionality
    Given I click on Car
    When I fill Title "New Toyota 002"
    Then I select of Condition "New"
    And I select of Brand "Toyota"
    And I select of Model "Corolla"
    And I fill Description "Description1"
    And I fill address "Badda"
    And I select Transmission "Automatic"
    And I fill Edition "test"
    And I fill Engine Capacity(CC) "1500"
    And I fill Manufacture Year "2022"
    And I fill Mileage(KM) "200"
    And I fill Registration Year "2023"
    And I select of Body type "Saloon"
    And I select Fuel Type
    And I fill price "2000000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\Toyota-Glanza-060520221539.jpg  |
      | C:\TestingPicture\corolla_w610_01.jpg |

    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: Vehicle category Rentals add posting functionality
    Given I click on Rentals
    When I fill Title "Rentals"
    And I fill Description "Description1"
    And I fill address "Badda"
    And I select of Rentals type "Car Rentals"
    And I fill price "5000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Banani"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                        |
      |C:\TestingPicture\Toyota-Glanza-060520221539.jpg  |
      | C:\TestingPicture\corolla_w610_01.jpg |
    And I click on submit button