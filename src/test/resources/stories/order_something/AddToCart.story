Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Story: Add to Cart
GivenStories: stories/search_attempt/SearchTestOne.story

Scenario: add a goods in the cart
Given i have searched for local items containing 'iPhone'
When i click the item
Then they should see the item description contains 'iPhone'
Given The user want to buy that product for '1'
When The user want to proceed the order
And The user want to choose the payment method by : <br> Method : 'Transfer' <br> Method Option : 'Mandiri' <br> and Sub Option : '0'
Then The user should get the order details
When The user want to check their order
And The user hover over a menu 'User' and then click the submenu 'Pesanan'
And The user select the 'Pesanan Saat Ini' option
And The user check the order validity
And User want to open the mailinator page
Then The user should see the mailinator web page
When The user want to open inbox in their account : 'akuYunaz@mailinator.com'
Then The user should see their email order
And The user want to switch to tab '0'
When The user want to cancel their order