Meta: @author :  YunazGilang

Narrative:
As a new user
I want to register
So that I can do more things in the website

Scenario: scenario description
Given The user is on the 'http://blibli.com'
When The user clicked the sign up button
And The user inputing his identity <br> email : 'akuYunaz@mailinator.com' <br> password : 'akuyunaz123'
Then The user shoud be redirected to the verification page or back to the mainpage(if already choose to verify or verify later)
And The user should be signed in and redirected to the website