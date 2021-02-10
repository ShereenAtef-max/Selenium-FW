Feature: User Registration
 I want to check that the user can register in our E-Commerce website
 
 Scenario: User Registarion
 
 Given User access the  home page
 When I click on Reigister link
 And I entered "<firstname>" , "<Lastname>" , "<email>" , "<Password>"
 Then the registration page displayed successfully
 
 Examples:
 | firstname | Lastname | email | Password |
 | FF | HH | FFHH@ss.com | ee7789999999 |
 | ddd | ggvv | ssrr@ss.com | nkini888998 |
 
 

