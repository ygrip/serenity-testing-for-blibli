package com.blibli.test.behaviours;

import com.blibli.test.models.UrlModels;
import com.blibli.test.models.UserModels;
import com.blibli.test.pages.BlibliPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Yunaz on 1/24/2017.
 */
public class RegisterBehaviour {
    BlibliPage mainpage;
    UserModels user;

    //Action to check wether the register popup has been displayed or not
    public Boolean isRegisterPopupDisplayed(){
        Boolean a, b, c;
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.RegisterElement registerElement = mainpage.new RegisterElement();

        a = registerElement.getFieldEmail().isDisplayed();
        b = registerElement.getFieldPassword().isDisplayed();
        c = registerElement.getBtnRegister().isDisplayed();

        if(a && b && c){
            return true;
        }else{
            return false;
        }
    }

    //Action to input value of email and password in the register popup
    public void inputIdentityToRegister(String email, String password){
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.RegisterElement registerElement = mainpage.new RegisterElement();

        registerElement.getFieldEmail().sendKeys(email);
        registerElement.getFieldPassword().sendKeys(password);

        user.setUserEmail(email);
        user.setPassword(password);
    }

    //Action to click the register button in register popup
    public void clickButtonRegister(){
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.RegisterElement registerElement = mainpage.new RegisterElement();

        registerElement.getBtnRegister().click();
    }

    //Action to check wether the login popup has been displayed or not
    public Boolean isTheLoginPopupDisplayed(){
        Boolean a, b, c;
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.LoginElement loginElement = mainpage.new LoginElement();

        a = loginElement.getFieldEmail().isDisplayed();
        b = loginElement.getFieldPassword().isDisplayed();
        c = loginElement.getBtnLogin().isDisplayed();

        if(a && b && c){
            return true;
        }else{
            return false;
        }
    }

    //Action to input the value of email and password in login popup
    public void inputIdentityToLogin(String email, String password){
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.LoginElement loginElement = mainpage.new LoginElement();

        loginElement.getFieldEmail().sendKeys(email);
        loginElement.getFieldPassword().sendKeys(password);

        user.setUserEmail(email);
        user.setPassword(password);
    }

    //Action to click the login button in login popup
    public void clickButtonLogin(){
        BlibliPage mainpage = new BlibliPage();
        BlibliPage.LoginElement loginElement = mainpage.new LoginElement();

        loginElement.getBtnLogin().click();
    }

    //Action to check wether user is in the verifivation page or not
    public Boolean isInVerificationPage(){
        return mainpage.getCurrentTitle().equals(UrlModels.TITLE_VERIFY_LATER);
    }

    //Action to click the verify later
    public void clickVerifyLater(){
        mainpage.getVerivicationLaterLink().click();
    }

    //Action to check wether the verification later popup has been displayed to the user or not
    public Boolean isVerifyLaterPopupDisplayed(){
        return mainpage.getVerivicationPopup().isDisplayed();
    }

    //Action to click the verify later on the verification later popup
    public void proceedVerifyLater(){
        mainpage.getVerivicationPopup().click();
    }
}
