Feature: User Test Results Are Displayed

Scenario: Test Results are calculated and displayed 
Given User sees Test page
When User clicks on finish test button
And User should see alert
And User clicks on Ok
Then User should see Test Submitted Successfully
And User should see Test Results

 