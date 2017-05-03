Meta: @author : YunazGilang

Narrative:
As a registered user
I want to update my profile
So that I can set detailed information about my profile
GivenStories: stories/login/LoginTestOne.story

Scenario: The user want to update their profile and click the Buku Alamat section
When The user hover over a menu 'User' and then click the submenu 'Profil'
Then The user should be redirected to profile page
When The user is inserting his fullname : 'Yunaz Gilang'
And The user is inserting his day of birth : '23' month of birth : 'Januari' Year of birth : '1996'
And The user is inserting his phone number : '082257170526'
And The user is selecting gender 'male'
Then the user is click save button
When The user hover over a menu 'User' and then click the submenu 'Alamat'
And The user want to 'close' the popup
And The user is inputting new data in alamat <br> Nama Lengkap : 'Yunaz Gilang' <br> Alamat : 'Jl. Klampis Ngasem 96' <br> Provinsi : 'Jawa Timur' <br> Kota 'Kota Surabaya' <br> Kecamatan : 'Sukolilo' <br> Kelurahan : 'Klampis Ngasem' <br> Email : 'akuYunaz@mailinator.com' <br> Handphone : '082257170526'
Then The user should see that their default address has been updated with the following details : <br> Nama Lengkap : 'Yunaz Gilang' <br> Alamat : 'Jl. Klampis Ngasem 96' <br> Provinsi : 'Jawa Timur' <br> Kota 'Kota Surabaya' <br> Kecamatan : 'Sukolilo' <br> Kelurahan : 'Klampis Ngasem' <br> Email : 'akuYunaz@mailinator.com' <br> Handphone : '082257170526'

