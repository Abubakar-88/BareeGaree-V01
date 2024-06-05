Feature: General user login and Dashboard functionality
  As a general user I can login and redirect into Dashboard
  So that I can maintain my Dashboard

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
    Then I click on Properties Category

  @GeneralUserDashboard @regression
  Scenario: General user can add post with Bedroom Furniture Property category
    Given I click on Bedroom Furniture
    When I fill Title "New Bedroom Furniture"
    Then I fill address "Badda"
    And I fill Description "Description1"
    And I fill price "20000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Badda"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                                |
      |C:\TestingPicture\imageFurniture1.jpg    |
      | C:\TestingPicture\Bedroom-Collection.jpg |
    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: General user can add post with Flat For Rent of Property category
    Given I click on Flat For Rent
    When I fill Title "Exclusive Flat For Rent"
    Then I fill No of Bedrooms "3"
    And I fill No of Bathrooms "2"
    And I fill Size "2000"
    And I select Car Parking "Yes"
    And I select Apartment Features "Full Furnished"
    And I select Facing Direction "East"
    And I select Completion Status "Ready"
    And I fill address "Badda"
    And I fill Description "Description1"
    And I fill Rent "20000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Badda"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                                      |
      | C\\TestingPicture\\imageFurniture1.jpg    |
      | C:\\TestingPicture\\Bed_roomRent.jpg       |
      | C:\\TestingPicture\\Bedroom-Collection.jpg |
    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: General user can add post with Land for Sale of Property category
    Given I click on Land for Sale
    When I fill Title "Exclusive1 Land For Sale"
    Then I select Land type
    And I fill land Size "2000"
    And I select land size unit "Square-Feet"
    And I fill address "Badda"
    And I fill Description "Description1"
    And I fill price "200000"
    And I select price unit "Total Price"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Badda"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                             |
      | C:\\TestingPicture\\landpic.jpg       |
      | C:\\TestingPicture\\landpic01.jpeg     |
      | C:\\TestingPicture\\Bedroom-Collection.jpg |
    And I click on submit button

  @GeneralUserDashboard @regression
  Scenario: General user can add post with Property For Rent of Property category
    Given I click on Property For Rent
    When I fill Title "Exclusive1 Land For Rent"
    Then I select Property type "Building"
    And I fill land Size "2000"
    And I select land size unit "Square-Feet"
    And I select Facing Direction "East"
    And I select Completion Status "On Going"
    And I fill address "Badda"
    And I fill Description "Description1"
    And I fill Rent perYear "200000"
    And I click on Negotiable check btn
    And I select the district "Dhaka"
    And I select the area of Dhaka "Badda"
    And I fill phone number "01548795251"
    And the user uploads the following images:
      | imagePath                             |
      | C:\\TestingPicture\\landpic.jpg       |
      | C:\\TestingPicture\\landpic01.jpeg     |
      | C:\\TestingPicture\\Bedroom-Collection.jpg |
    And I click on submit button