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