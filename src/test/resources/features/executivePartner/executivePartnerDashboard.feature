Feature: Executive partner Dashboard functionality
  As a Executive I can post in social media with successfully
  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on Executive partner of login menu
    Then I fill email "testUserPartner03"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Bakar Siddique" in the dashboard

  @ExecutivePartner @regression
   Scenario: Ad Boosting for my active user
     " **As a Executive Partner I want to Ad boosting for my active user
     So that I can do my active user post in the promoted according to promotion activity**"

     Given I click on the active user
     When I click on the ViewAd link "abdullah74@gmail.com"
     Then I should be navigated to the user's active postList page
     And the user information should be displayed correctly
       | Name            | Abdullah Mia        |
       | User Name       | abdullah47          |
       | Email           | abdullah74@gmail.com|
       | Phone Number    | 01856231773         |
       | WhatsApp Number | 01856271473         |
       | Reference Code  | RC-17282024195      |
       | District        | Dhaka               |
       | Area            | Badda               |
     And I click on Boost your Ad
     And I select Between promotion
     And I select of Between promotion for 7 Day
     And I click on Continue btn
     And I select Top post
     And I select of Top post for 5 Day
     And I click on Continue btn
     And I select Payment By Bundle
     And I should see promotion amount "840" is added correctly
     Then I click on Make payment btn
     And I navigated to the all post of bangladesh
     Then the top post should have the title "Mens Hands Begs2"


  Scenario: Ad Boosting for another active user
  " **As a Executive Partner I want to Ad boosting without my active user
  So that I can do this user post in the promoted according to promotion activity**"

    Given I click on All ads
    And I navigated to the all post of bangladesh
    When I click on Rentals car
    Then I click on the post details boost
    And I navigated to the boost page of this post
    And I select Between promotion
    And I select of Between promotion for 5 Day amount
    And I click on Continue btn
    And I select Payment By Bundle
    And I click on Make payment btn
    And I navigated to the all post of bangladesh
    Then the top post should have the title "Rentals"

   # @write post place holder article spelling wrong
  @ExecutivePartner
  Scenario Outline: Executive partner article post

#  Given I should see "Write a post" title in place holder
   When I click on write post
    Then I want to write a article "<article>"
    And I choose about article image
      | imagePath                        |
      |C:\TestingPicture\ob_1716367218.jpg |
    And I click on post submit btn


    Examples:
      | article |
      |During the three-day final, the teams performed four missions including science exploration, autonomous navigation, extreme terrain traversal and Equipment servicing missionsto demonstrate the capabilities of their rover and operation skills |

  @ExecutivePartner
  Scenario: Executive partner download pdf and comment
    Given I click on comment icon
    When I write the comment in the post "Excellent I Like it"
    Then I click comment submit btn
    And I click on download pdf btn
    And I download "myfile.pdf" in my computer with pdf
