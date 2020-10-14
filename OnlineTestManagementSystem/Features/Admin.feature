Feature: Checks if Admin is logged in or not

Scenario: Admin Successfull Login
Given Admin is on user login page
When Admin enters username and password
And Admin clicks on submit button
Then Admin should see a message "Admin Login successfull"