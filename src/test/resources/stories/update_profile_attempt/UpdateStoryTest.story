Meta: @author : YunazGilang

Narrative:
As a registered user
I want to update my profile
So that I can set detailed information about my profile
GivenStories: stories/sign_up_attempt/SignUpTest.story

Scenario: The user want to update their profile
When The user hover over a menu 'User' and then click the submenu 'Profil'
Then The user should be redirected to profile page
When The user is inserting his fullname : 'Yunaz Gilang'
And The user is inserting his day of birth : '1' month of birth : 'Januari' Year of birth : '2010'
And The user is inserting his phone number : '081234567890'
And The user is selecting gender 'male'
Then the user is click save button