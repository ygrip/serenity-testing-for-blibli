Meta: @author :  YunazGilang

Narrative:
As a new user
I want to register
So that I can do more things in the website

GivenStories: stories/blibli/OpenBlibli.story

Scenario: The user now want to sign up as new user
Given The popup is still exist user choose to 'close'
When The user clicked the sign up button
And The user inputing his identity <br> email : 'akuYunazGilang@mailinator.com' <br> password : 'akuyunaz123'
Then The user shoud be redirected to the verification page or back to the mainpage(if already choose to verify or verify later)
Given The user have been signed in and is in the website