Feature: Pending post functionality
  As a admin
  I want to check in Pending Electronic list such as filter, sorting, search post with successfully

  Background:
    Given I am on the admin login page
    When I fill email "admin@gmail.com"
    Then I fill password "@Bgca01##@"
    And I click on admin login submit btn
    And I hover on Pending Post

   # pdf file download not included all information
  @admin @regression
  Scenario: Download the Excel file and check column headers
    Given I Click on Pending All post
    When I download the Excel file
    Then I check the Excel file "PendingAllList.csv" contains the correct column headers
      | CreatedBy         |
      | Title             |
      | CategoryName      |
      | SubCategoryName   |
      | TotalPendingPost  |
      | CreatedDateString |

    And I check the values in the Excel file "PendingAllList.csv" match the website values
      | CreatedBy         |
      | Title             |
      | CategoryName      |
      | SubCategoryName   |
      | TotalPendingPost  |
      | CreatedDateString |
  #  And I download "Export.pdf" in my computer with pdf file


   @admin @regression
  Scenario Outline: Check column headers and sorting of All active General user functionality
    Given I Click on Pending All post
    When I should see the following column headers
      | User Name          |
      | Title              |
      | Category           |
      | Sub Category       |
      | Total Pending Post |
      | Created Date       |

    Then I click on the "<headerName>" column header
    And I should see the table sorted by "<headerName>" in "ascending" order
    Examples:
      | headerName |
      | User Name  |
      | Title      |
      | Category          |
      | Sub Category      |
      | Total Pending Post |
      | Created Date     |

  @admin @regression
  Scenario Outline: Filter by User Name with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I Click on Pending All post
    When I filter the "User Name" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "User Name" column should contain the value "<expectedValue>"
    And I filter the "User Name" column with condition "Is not equal to" and value "<expectedValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "User Name" column should not contain the value "<expectedValue>"

    Examples:
      | condition   | conditionValue | expectedValue  | orLogical   | orLogicalValue |
      | Is equal to | testUser02     | testUser02     | Is equal to | Mehjabin1      |
      | Starts with | Faarrh         | Faarrhhaann    | Starts with | Murad          |
      | Contains    | Sonia          | SoniaAkter1    | Contains    | QAtest         |
      | Ends with   | gmail.com      | user@gmail.com | Ends with   | GM             |

  @admin @regression
  Scenario: Filter by User Name with condition Does not
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I Click on Pending All post
    When I filter the "User Name" column with condition "Does not contain" and value "Sonia"
    Then I select or logical "And"
    And I filter the column with Or logical "Does not contain" and value "Mehjabin"
    And I apply the filter
    And the "User Name" column should not contain the value "SoniaMunaGU"

  @admin @regression
  Scenario Outline: Filter by Title with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I Click on Pending All post
    When I filter the "Title" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "Title" column should contain the value "<expectedValue>"
    And I filter the "Title" column with condition "Is not equal to" and value "<expectedValue>"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Title" column should not contain the value "<expectedValue>"

    Examples:
      | condition   | conditionValue | expectedValue         | orLogical   | orLogicalValue |
      | Is equal to | Tripod         | Tripod                | Is equal to | Mehjabin1      |
      | Starts with | Macbook        | Macbook M2 Pro        | Starts with | Murad          |
      | Contains    | water purifier | PureIT water purifier | Contains    | QAtest         |
      | Ends with   | Wallets        | Men's Bags Or Wallets | Ends with   | GM             |

  @admin @regression
  Scenario Outline: Filter by Sub Category with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I Click on Pending All post
    When I filter the "Sub Category" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "Sub Category" column should contain the value "<expectedValue>"
    And I filter the "Sub Category" column with condition "Is not equal to" and value "<expectedValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Sub Category" column should not contain the value "<expectedValue>"

    Examples:
      | condition | conditionValue | expectedValue                   | orLogical | orLogicalValue |
      | Is equal to | Car            | Car                             | Is equal to | Mehjabin1      |
      | Starts with | Sales          | Sales Executive                 | Starts with | Murad          |
      | Contains  | Laptop         | Computer And Laptop Accessories | Contains  | QAtest         |
      | Ends with | Accessories    | ACs And ACs Accessories         | Ends with | GM             |

  @admin @regression
  Scenario Outline: Filter by Date with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I Click on Pending All post
    When I filter the "Created Date" column with condition "<condition>" and value "<conditionValue>"
    Then I select logical condition of date filter "And"
    Then I filter the Date column with Or logical "<orLogical>" and value "<orLogicalValue>"
    Then I apply the filter
    And the "Created Date" column should contain the value "<expectedValue>"

    Examples:
      | condition  | conditionValue | expectedValue | orLogical | orLogicalValue |
      | Begin Date | 4/3/2024       | 	29-04-2024      | End Date  | 5/22/2024      |



  @admin @regression
  Scenario: Pending Post Activation Functionality
  "** As an admin
  I want to status activate
  So that I can find specific records easily with activation Post in the active Post"

    Given I Click on Pending All post
    When I click on the Preview link for update post "Office Admin"
    Then I should be navigated to the post preview page
    And I click on Edit btn
    And I fill Title "Office Admin2"
    And I select of Job type "Per Time"
    And I fill contact phone number "01548795299"
    And I fill contact email "buyme09@gamil.com"
   # And I pick application deadline "28"
    And I click on update btn
    And I want to select post status "Active"
    Then I click on pending post update btn
    And I hover on Active post
    And I click on All active post
    And the "Title" column should contain the value "Office Admin2"

  @admin @regression
  Scenario:Pending Post Pagination works correctly
    Given I Click on Pending All post
    When I want to see pagination is perfectly work so i select page number 10
    Then I navigate to the first page
    And the pagination info should be "1 - 10 of 269 items"

    When I navigate to the next page
    Then the pagination info should be "11 - 20 of 269 items"

    When I navigate to the last page
    Then the pagination info should be "261 - 269 of 269 items"

    When I navigate to the previous page
    Then the pagination info should be "251 - 260 of 269 items"

    When I navigate to the first page
    Then the pagination info should be "1 - 10 of 269 items"

