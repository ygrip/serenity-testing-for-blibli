Meta: @author : YunazGilang

Narrative:
As a user
I want to perform an action to login in the website
So that I can do more things in the website

GivenStories: stories/open_blibli_page_attempt/OpenBlibli.story

Scenario: user is attempting login by inputing random username and password
Meta: @skip
Given The popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : 'yunaz.gilang@gmail.com' and password : 'abscAdac'
Then The user should see the error result

Scenario: user is attempting login by just inputting random username without password
Meta: @skip
Given The popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : 'yunaz.gilang@gmail.com' and password : ''
Then The user should see the error result

Scenario: user is attempting login by not inputting username but just a random password
Meta: @skip
Given The popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : '' and password : 'abscAdac'
Then The user should see the error result

Scenario: user is attempting login by not inputting anything
Meta: @skip
Given The popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : '' and password : ''
Then The user should see the error result

Scenario: user is attempting to login with right credentials
Meta:
Given The popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : 'akuYunaz@mailinator.com' and password : 'akuyunaz123'
Then The user shoud be redirected to the verification page or back to the mainpage(if already choose to verify or verify later)
Given The user have been signed in and is in the website