package com.blibli.test.behaviours;

import com.blibli.test.models.UrlModels;
import com.blibli.test.pages.BlibliPage;

/**
 * Created by Yunaz on 1/25/2017.
 */
public class ProfileBehaviour {
    BlibliPage mainpage;

    //Action to check wether user is in the profile page or not
    public Boolean checkIsInTheProfilepage(){
        return mainpage.getCurrentURL().equals(UrlModels.URL_PROFILE);
    }

    //Action to fill the user profile information
    public void fillTheUserProfile(String fullName, String day, String month, String year, String phone, String gender, String email, Boolean newsletter){
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.ProfilePageElement profilePageElement = mainpage.new ProfilePageElement();

        profilePageElement.getFieldNamaLengkap().sendKeys(fullName);
    }
}
