package com.blibli.test.behaviours;

import com.blibli.test.models.UserModels;
import com.blibli.test.pages.BlibliPage;
import com.blibli.test.steps.actor.User;
import org.openqa.selenium.Keys;

/**
 * Created by Yunaz on 1/24/2017.
 */
public class SearchBehaviour {
    BlibliPage mainpage;
    UserModels user;

    //Action to type something in the search field in mainpage
    public void typeSomethingInSearchField(String item){
        mainpage.getSearchField().clear();
        mainpage.getSearchField().sendKeys(item);
        user.setUserSearch(item);
    }

    //Action to click the search button in mainpage
    public void hitTheSearchButton(){
        mainpage.getButtonSearch().click();
    }

    //Action to hit enter in the search field in mainpage
    public void hitEnterInSearchField(){
        mainpage.getSearchField().sendKeys(Keys.RETURN);
    }

    //Action to check wether user get the search result or not
    public Boolean getTheSearchResult(){
        if(mainpage.getSearchResultElement().isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
}
