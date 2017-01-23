Meta: @author : YunazGilang

Narrative:
As a user
I want to hover a menu
So that I can choose the sub menu from the drop down list

GivenStories: stories/blibli/OpenBlibli.story

Scenario: The user is hovering the mobile app item and then clicked the Windows link
When The user hover over a menu 'Mobile' and then click the submenu 'Windows'
And The user want to scroll the page '0' x, '750' y
Then Thes user should directed to the 'Windows' page
And The user choose to 'go back' the first tab

Scenario: The user is hovering the mobile app item and then clicked the iOS link
Meta:@skip
When The user hover over a menu 'Mobile' and then click the submenu 'iOS'
Then Thes user should directed to the 'iOS' page
And The user choose to 'go back' the first tab

Scenario: The user is hovering the mobile app item and then clicked the Android link
Meta:@skip
When The user hover over a menu 'Mobile' and then click the submenu 'Android'
Then Thes user should directed to the 'Android' page
And The user choose to 'close' the first tab