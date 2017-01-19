Meta: @author : YunazGilang

Narrative:
As a user
I want to hover a menu
So that I can choose the sub menu from the drop down list

Scenario: The user is hovering the mobile app item and then clicked the Windows link
Given The user is on the 'http//blibli.com'
When The user hover over a menu and wanted to click the 'Windows' submenu
Then Thes user should directed to the 'Windows' page
And The user choose to 'go back' the first tab

Scenario: The user is hovering the mobile app item and then clicked the iOS link
Given The user is on the 'http//blibli.com'
When The user hover over a menu and wanted to click the 'iOS' submenu
Then Thes user should directed to the 'iOS' page
And The user choose to 'go back' the first tab

Scenario: The user is hovering the mobile app item and then clicked the Android link
Given The user is on the 'http//blibli.com'
When The user hover over a menu and wanted to click the 'Android' submenu
Then Thes user should directed to the 'Android' page
And The user choose to 'close' the first tab