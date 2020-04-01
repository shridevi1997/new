@nonui
Feature: Shout Feature
Scenario: Sean and Lucia are within the range
Given Sean and Lucia are 20 meters away
When Aean shouts "free coffee" to Lucia
Then Lucia listens to the message

@nonui
Scenario: Sean and Lucia are not within the range
Given Sean and Lucia are 300 meters away
When Aean shouts "free coffee" to Lucia
Then Lucia doesnot listens to the message

