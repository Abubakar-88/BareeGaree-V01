Feature: Executive partner Dashboard functionality
  As a Executive I can post in social media with successfully
  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
    Given I click on login menu
    When I click on Executive partner of login menu
    Then I fill userName "testUserPartner03"
    And I fill password "sid21@A!"
    And I click on login submit btn
    And I should see my profile name "Abu Bakar Siddique" in the dashboard


   # @write post place holder article spelling wrong
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

  Scenario: Executive partner download pdf and comment
    Given I click on comment icon
    When I write the comment in the post "Excellent I Like it"
    Then I click comment submit btn
    And I click on download pdf btn
    And I download "myfile.pdf" in my computer with pdf
