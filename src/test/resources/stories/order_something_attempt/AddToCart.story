Meta: @author : YunazGilang

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Story: Add to Cart
GivenStories: stories/search_attempt/SearchTestOne.story

Scenario: add a goods in the cart
Given i have searched for local items containing 'Nokia'
When i click the item
Then they should see the item description contains 'Nokia'
Given The user want to buy that product for '2'
When The user want to proceed the order
And The user want to choose the payment method by : <br> Method : 'Transfer' <br> Method Option : 'Mandiri' <br> and Sub Option : '0'
Then The user should get the order details
Given The user is on the 'https://www.blibli.com/'
When The user hover over a menu 'User' and then click the submenu 'Pesanan'
And The user select the 'Pesanan Saat Ini' option
And The user check the order validity
Given The user is on the 'https://www.mailinator.com/'
When The user want to open inbox in their account : 'akuYunaz@mailinator.com'
Then The user should see their email order
And The user want to delete the email
Given The user is on the 'https://www.blibli.com/'
When The user hover over a menu 'User' and then click the submenu 'Pesanan'
And The user want to cancel their order
And The user select the 'Pesanan Batal' option
Given The user is on the 'https://www.mailinator.com/'
When The user want to open inbox in their account : 'akuYunaz@mailinator.com'
Then The user should see their email order was cancelled
And The user want to delete the email