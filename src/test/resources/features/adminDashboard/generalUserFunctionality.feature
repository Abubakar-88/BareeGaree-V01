Feature: General user functionality
  As a admin
  I want to verify all active list such as filtering sorting of header column name and edit post with successfully

  Background:
    Given I am on the admin login page
    When I fill email "admin@gmail.com"
    Then I fill password "@Bgca01##@"
    And I click on admin login submit btn
    And I hover on General User

   # pdf file download not included all information
  # Bug:- There are should be comlumn name totalpost in the excel file but found TotalActivepost
  @admin @regression
  Scenario: Download the Excel file and check column headers
    Given I click on all active general user
    When I download the Excel file
    Then I check the Excel file "UserList.csv" contains the correct column headers
      | UserName          |
      | Email             |
      | PhoneNumber       |
      | WhatsAppNumber    |
      | MembershipStatus  |
      | UserStatus        |
      | UserRole          |
      | ReferenceCode     |
      | ApprovedBy        |
      | TotalActivePost   |
      | CreatedDateString |
  #Bug:- There are should be email value in the email column in the excel file but found reference code
    And I check the values in the Excel file "UserList.csv" match the website values
      | UserName          |
      | Email             |
      | PhoneNumber       |
      | WhatsAppNumber    |
      | MembershipStatus  |
      | UserStatus        |
      | UserRole          |
      | ReferenceCode     |
      | ApprovedBy        |
      | TotalActivePost   |
      | CreatedDateString |
    And I download "Export.pdf" in my computer with pdf file


  # I think here should be header name CreatedDate instanceOf CreatedDateString
  @admin @regression
  Scenario Outline: Search with different keyword of General user
    Given I click on all active general user
    When I search with "<username>"
    Then I should see "User Name" search results that match the "<username>"
    And I search with "<PhoneNumber>"
    Then I should see "Phone Number" search results that match the "<PhoneNumber>"
    And I search with "<Email>"
    Then I should see "Email" search results that match the "<Email>"
    And I search with "<ReferenceCode>"
    Then I should see "Reference Code" search results that match the "<ReferenceCode>"


    Examples:
      | username  | PhoneNumber | Email                | ReferenceCode  |
      | Asif07    | 01911960677 | sikehod940@dacgu.com | RC-7232024193  |
      | Imran1234 | 01379949799 | Mehjabin1@gmail.com  | RC-22342024342 |

  @admin @regression
  Scenario Outline: Check column headers and sorting of All active General user functionality
    Given I click on all active general user
    When I should see the following column headers
      | User Name         |
      | Email             |
      | Phone Number      |
      | WhatsApp Number   |
      | Membership Status |
      | User Status       |
      | User Role         |
      | Reference Code    |
      | Approved By       |
      | Total Post        |
      | Created Date      |

    Then I click on the "<headerName>" column header
    And I should see the table sorted by "<headerName>" in "ascending" order
    Examples:
      | headerName        |
      | User Name         |
      | Email             |
      | Phone Number       |
      | WhatsApp Number   |
      | Membership Status |
      | User Status       |
      | User Role         |
      | Reference Code     |
      | Approved By        |
      | Total Post    |
     | Created Date |

  @admin @regression
  Scenario Outline: Filter by User Name with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on all active general user
    When I filter the "User Name" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "User Name" column should contain the value "<expectedValue>"
    And I filter the "User Name" column with condition "Is not equal to" and value "<conditionValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "User Name" column should not contain the value "<expectedValue>"
    Examples:
      | condition   | conditionValue | orLogical   | orLogicalValue | expectedValue |
      | Is equal to | Imran1234      | Is equal to | Mehjabin1      | Imran1234     |
      | Starts with     | sonia          | Starts with     | Murad        | sonia123      |
      | Contains        | Asif      | Contains        | QAtest        | Asif07 |
      | Ends with | Alam1          | Ends with | GM             | SoniaAlam1    |

  @admin @regression
  Scenario: Filter by User Name with condition Does not
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on all active general user
    When I filter the "User Name" column with condition "Does not contain" and value "Sonia"
    Then I select or logical "And"
    And I filter the column with Or logical "Does not contain" and value "Mehjabin"
    And I apply the filter
    And the "User Name" column should not contain the value "SoniaMunaGU"

  @admin @regression
  Scenario Outline: Filter by Email with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on all active general user
    When I filter the "Email" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "Email" column should contain the value "<expectedValue>"
    And I filter the "Email" column with condition "Is not equal to" and value "<conditionValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Email" column should not contain the value "<expectedValue>"

    Examples:
      | condition   | conditionValue         | orLogical   | orLogicalValue       | expectedValue          |
      | Is equal to | farhanimran483@123.com | Is equal to | sikehod940@dacgu.com | farhanimran483@123.com |
      | Starts with | pidaxe1127             | Starts with | shishir              | pidaxe1127@azduan.com  |
      | Contains    | Mehjabin1              | Contains    | general              | Mehjabin1@gmail.com    |
      | Ends with   | comsb.com              | Ends with   | bin33                | gosojob369@comsb.com   |

  @admin @regression
  Scenario Outline: Filter by Phone Number with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on all active general user
    When I filter the "Phone Number" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "Phone Number" column should contain the value "<expectedValue>"
    And I filter the "Phone Number" column with condition "Is not equal to" and value "<expectedValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Phone Number" column should not contain the value "<expectedValue>"
    Examples:
      | condition   | conditionValue | orLogical   | orLogicalValue | expectedValue |
      | Is equal to | 01798242152    | Is equal to | 01745001590    | 01798242152   |
      | Starts with | 0187           | Starts with | 01679820556    | 01879899001   |
      | Contains    | 32032          | Contains    | 67335          | 01732032180   |
      | Ends with   | 3457           | Ends with   | 75678          | 01845633457   |
  @admin @regression
  Scenario Outline: Filter by Reference Code with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on all active general user
    When I filter the "Reference Code" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    Then I apply the filter
    And the "Reference Code" column should contain the value "<expectedValue>"
    And I filter the "Reference Code" column with condition "Is not equal to" and value "<expectedValue>"
    And I apply the filter
    And the "Reference Code" column should not contain the value "<expectedValue>"
    And I filter the "Reference Code" column with condition "Is not equal to" and value "<expectedValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Reference Code" column should not contain the value "<expectedValue>"

    Examples:
      | condition   | conditionValue | orLogical   | orLogicalValue  | expectedValue  |
      | Is equal to | RC-25202024433 | Is equal to | RC-101420235812 | RC-25202024433 |
      | Starts with | RC-7232        | Starts with | RC-1014202      | RC-7232024193  |
      | Contains    | 52024          | Contains    | 3420243         | RC-28352024392 |
      | Ends with   | 4342           | Ends with   | 35812           | RC-22342024342 |


  @admin @regression
  Scenario: Pending to Activation General user  Functionality
  "** As an admin
  I want to status activate
  So that I can find specific records easily with activation user name in the active user"

    Given I click on all pending general user
    When I click on the Preview link for update "shahnaj@gmail.com"
    Then I should be navigated to the user's preview page
    And I want to select status "Active"
    Then I click on update btn
    And I hover on General User
    And I click on all active general user
    And the "Email" column should contain the value "shahnaj@gmail.com"

  @admin @regression
  Scenario: Pending to Rejected General user Functionality
      "** As an admin
      I want to status activate
      So that I can find specific records easily with activation user name in the active user"

    Given I click on all pending general user
    When I click on the Preview link for update "SumiSultanaCity@gail.com"
    Then I should be navigated to the user's preview page
    And I want to select status "Reject"
    And I write the remark "You didn't fulfill our condition!"
    Then I click on update btn
    And I hover on General User
    And I click on all rejected general user
    And the "Email" column should contain the value "SumiSultanaCity@gail.com"

  @admin @regression
  Scenario: Active to Inactive General user Functionality
    "** As an admin
    I want to status activate
    So that I can find specific records easily with activation user name in the active user"

    Given I click on all active general user
    When I click on the Preview link for update "twe@gmail.com"
    Then I should be navigated to the user's active preview page
    And I want to select status "Inactive"
    And I write the remark "You didn't fulfill our condition!"
    Then I click on update btn
    And I hover on General User
    And I click on all Inactive general user
    And the "Email" column should contain the value "twe@gmail.com"


  @admin @regression
  Scenario: Pagination works correctly
    Given I click on all active general user
    When I want to see pagination is perfectly work so i select page number 10
    Then I navigate to the first page
    And the pagination info should be "1 - 10 of 39 items"

    When I navigate to the next page
    Then the pagination info should be "11 - 20 of 39 items"

    When I navigate to the last page
    Then the pagination info should be "31 - 39 of 39 items"

    When I navigate to the previous page
    Then the pagination info should be "21 - 30 of 39 items"

    When I navigate to the first page
    Then the pagination info should be "1 - 10 of 39 items"

