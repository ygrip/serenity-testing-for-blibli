Meta: @skip

Narrative:
As a user
I want to perform an action to login in the website
So that I can do more things in the website

Scenario: user is attempting login by inputing random username and password
Given The user is on the 'http://blibli.com'
And the popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : 'yunaz.gilang@gmail.com' and password : 'abscAdac'
Then The user should see the error result

Scenario: user is attempting login by just inputting random username without password
Given The user is on the 'http://blibli.com'
And the popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : 'yunaz.gilang@gmail.com' and password : ''
Then The user should see the error result

Scenario: user is attempting login by not inputting username but just a random password
Given The user is on the 'http://blibli.com'
And the popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : '' and password : 'abscAdac'
Then The user should see the error result

Scenario: user is attempting login by not inputting anything
Given The user is on the 'http://blibli.com'
And the popup is still exist user choose to 'close'
When The user is entering his credentials : <br> username : '' and password : ''
Then The user should see the error result