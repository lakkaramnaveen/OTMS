Feature: Checks if user is logged in or not

Scenario: Successfull Login
Given User is on user login page
When User enters username and password
And User clicks on submit button and gets a alert
Then User should see a message "User Login successfull"