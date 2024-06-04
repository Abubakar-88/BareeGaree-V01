Feature: Active post functionality
  As a admin
  I want to verify all active list such as filtering sorting of header column name and edit post with successfully

  Background:
    Given I am on the admin login page
    When I fill userName "admin@gmail.com"
    Then I fill password "@Bgca01##@"
    And I click on login submit btn
    And I hover on Active post

  @admin @regression
  Scenario: Download the Excel file and check column headers
    Given I click on active Electronics
    When I download the Excel file
    Then I check the Excel file "ActiveElectronicList.csv" contains the correct column headers
      | CreatedBy         |
      | Title             |
      | CategoryName      |
      | SubCategoryName   |
      | ApprovedBy        |
      | TotalActivePost   |
      | CreatedDateString |
    And I check the values in the Excel file "UserList.csv" match the website values
      | CreatedBy         |
      | Title             |
      | CategoryName      |
      | SubCategoryName   |
      | ApprovedBy        |
      | TotalActivePost   |
      | CreatedDateString |
    And I download "Export.pdf" in my computer with pdf file


  # I think here should be header name CreatedDate instanceOf CreatedDateString
  @admin @regression
  Scenario Outline: Search with different keyword of Electronics service
    Given I click on active Electronics
    When I search with "<username>"
    Then I should see "User Name" search results that match the "<username>"
    And I search with "<subCategory>"
    Then I should see "Sub Category" search results that match the "<subCategory>"
    And I search with "<title>"
    Then I should see "Title" search results that match the "<title>"
#    And I search with "<createdDate>"
#    Then I should see "Created Date" search results that match the "<createdDate>"


    Examples:
      | username      | subCategory        | title           | createdDate |
      | soniaphoneotp | Mobile Accessories | IPad Air 5      | 06-02-2024  |
      | SoniaMunaGU   | Tablets            | New ac for sale | 14-01-2024  |

  @admin @regression
  Scenario Outline:Verify column headers and sorting of Electronics active post functionality
    Given I click on active Electronics
    When I should see the following column headers
      | User Name         |
      | Title             |
      | Category          |
      | Sub Category      |
      | Approved By       |
      | Total Active Post |
      | Created Date      |

    Then I click on the "<headerName>" column header
    And I should see the table sorted by "<headerName>" in "ascending" order
    Examples:
      | headerName        |
      | User Name         |
      | Title             |
      | Category          |
      | Sub Category      |
      | Approved By       |
      | Total Active Post |
      | Created Date      |

  @admin @regression
  Scenario Outline: Filter by User Name with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on active Electronics
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
      | condition       | conditionValue | orLogical       | orLogicalValue | expectedValue      |
      | Is equal to     | LamiaMehjabin  | Is equal to     | Mehjabin33     | LamiaMehjabin      |
      | Starts with     | sonia          | Starts with     | shishir        | soniaphoneotp      |
      | Contains        | Shahadat       | Contains        | general        | Shahadatshanto1991 |
      | Ends with       | Muna20         | Ends with       | bin33          | SoniaMuna20        |

  @admin @regression
  Scenario: Filter by User Name with condition And "And" logical
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on active Electronics
    When I filter the "User Name" column with condition "Does not contain" and value "soniaphoneotp"
    Then I select or logical "And"
    And I filter the column with Or logical "Does not contain" and value "Mehjabin33"
    And I apply the filter
    And the "User Name" column should not contain the value "soniaphoneotp"

  @admin @regression
  Scenario Outline: Filter by Title with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on active Electronics
    When I filter the "Title" column with condition "<condition>" and value "<conditionValue>"
    Then I select or logical of user name filter "Or"
    And I filter the column with Or logical "<orLogical>" and value "<orLogicalValue>"
    And I apply the filter
    And the "Title" column should contain the value "<expectedValue>"
    And I filter the "Title" column with condition "Is not equal to" and value "<expectedValue>"
    Then I select or logical of user name filter "And"
    And I filter the column with Or logical "Is not equal to" and value "<orLogicalValue>"
    And I apply the filter
    And the "Title" column should not contain the value "<expectedValue>"

    Examples:
      | condition   | conditionValue | orLogical   | orLogicalValue | expectedValue          |
      | Is equal to     | Air Conditioner  | Is equal to     | Daikin Ac 1 Ton     | Air Conditioner      |
      | Starts with | Key            | Starts with | shishir        | Keyboard               |
      | Contains    | Camcorder      | Contains    | general        | New Camcorder for sale |
      | Ends with       | sale         | Ends with       | bin33          | New IPS for sale        |


  @admin @regression
  Scenario Outline: Filter by Sub Category with condition
  "** As an admin
  I want to filter table data
  So that I can find specific records easily"
    Given I click on active Electronics
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
      | condition       | conditionValue     | orLogical       | orLogicalValue | expectedValue        |
      | Is equal to     | Mobile Accessories | Is equal to     | TVs            | Mobile Accessories   |
      | Starts with     | Desktop            | Starts with     | Home           | Desktop Computers    |
      | Contains        | Security           | Contains        | general        | CCTV And Security    |
      | Ends with       | Camcorder          | Ends with       | bin33          | Camera And Camcorder |

  @admin @regression
  Scenario Outline: Filter by Date with condition
      "** As an admin
      I want to filter table data
      So that I can find specific records easily"
    Given I click on active Electronics
    When I filter the "Created Date" column with condition "<condition>" and value "<conditionValue>"
    Then I select logical condition of date filter "And"
    Then I filter the Date column with Or logical "<orLogical>" and value "<orLogicalValue>"
    Then I apply the filter
    And the "Created Date" column should contain the value "<expectedValue>"

    Examples:
      | condition  | conditionValue | expectedValue | orLogical | orLogicalValue |
      | Begin Date | 2/29/2024     | 3/12/2024    | End Date  | 2/29/2024        |


  @admin @regression
  Scenario Outline: Filter by Total Active Post with condition And "Or" logical
      "** As an admin
      I want to filter table data
      So that I can find specific records easily"
    Given I click on active Electronics
    When I filter the "Total Active Post" column with Total active condition "<condition>" and value "<conditionValue>"
    Then I apply the filter
    And the "Total Active Post" column should contain the value "<expectedValue>"

    Examples:
      | condition                   | conditionValue | expectedValue |
      | Is equal to                 | 12.00          | 12            |
      | Is greater than or equal to | 14             | 14            |
      | Is greater than             | 13             | 14            |
      | Is less than or equal to    | 4              | 4             |
      | Is less than                | 3              | 2             |

  @admin @regression
  Scenario: Pagination works correctly
    Given I click on active Electronics
    When I want to see pagination is perfectly work so i select page number 10
    Then I navigate to the first page
    And the pagination info should be "1 - 10 of 55 items"

    When I navigate to the next page
    Then the pagination info should be "11 - 20 of 55 items"

    When I navigate to the last page
    Then the pagination info should be "51 - 55 of 55 items"

    When I navigate to the previous page
    Then the pagination info should be "41 - 50 of 55 items"

    When I navigate to the first page
    Then the pagination info should be "1 - 10 of 55 items"

