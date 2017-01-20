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