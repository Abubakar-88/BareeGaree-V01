Feature: Signup Without Any error
  Background:
    Given I am on the homepage
    When Satisfy that homepage is visible
  @smoke
Scenario Outline: Customer can be Signup with successfully
 Given I am on the homepage
  When I click on the Signup Menu
  Then I click on the General User of dropdown menu
  And I should see the "Sign Up General User" title on the signup page
  And I fill out the signup form with data from "<SheetName>" and <RowNumber>
  And I fill first name
  And I fill last name
  Then I fill userName
  And I fill email
  And I fill mobile number
  And I fill whatsapp number
  And I select district name
  And I select thana name
  And I fill password
  And I fill confirm password
  And I agree with the terms and conditions
  Then I click on the Sign Up button

Examples:
|SheetName | RowNumber |
|genBaree |  0       |



  Scenario: check for member position
    Then I hover on Member menu
    And I click on Platinum
    And I should see member position name filter by Platinum
