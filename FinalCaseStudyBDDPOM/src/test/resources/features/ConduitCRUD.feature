Feature: Conduit CRUD operations

Background: Login into app
Given User is on login page
When User provide "maheswari77@gmail.com" and "College@123."
Then User should be on Home Page

Scenario: Create new Article
Given User should be on Article Page
When Use enters Article details
|title|Desc|Content|tag|
|Selenium types|Types|Selenium, selenium RC, selenium Grid, webdriver|types|
Then Article must be created

Scenario: View Article
Given User should be on Global Feed page
When User select an article "Selenium types"
Then Article detail page must be displayed

Scenario: Update an Article
Given User should be on Global Feed page
When User select an article "Selenium types"
When User update article detail
Then Article detail page must be updated

Scenario: Delete an Article
Given User should be on Global Feed page
When User select an article "selenium type11"
When User delete article 
Then Article must be deleted

