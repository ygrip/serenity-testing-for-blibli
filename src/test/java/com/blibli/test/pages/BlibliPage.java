package com.blibli.test.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Yunaz on 1/17/2017.
 */
@DefaultUrl("http://www.blibli.com/")
public class BlibliPage extends PageObject{
    //login button
    private String login = "//body//*[@id='gdn-login-registrasi']";

    private String signup = "//body//*[@id='gdn-daftar']";

    private String btn_for_login ="//body//*[@id='gdn-submit-login']";

    private String nama_user = "//body//*[@id='loginEmail']";

    private String password_user = "//body//*[@id='loginPassword']";

    private String label = "//body//*[@id='gdnloginErrorLabel']";

    private String search_field = "//body//*[@id='autocomplete-wrapper']//input[@type='text']";

    private String search_button = "//body//*[@id='gdn-search-button']";

    private String search_result_found = "//body//*[@id='blibli-main-ctrl']/section/div/div[@id='catalogViewSection']";

    public void user_choose_to_login(){
        WebElement btn_login = getDriver().findElement(By.xpath(login));
        btn_login.click();
    }

    public void closePopUp(){
        try {
            WebElement container = getDriver().findElement(By.xpath("//body//*[@class='insider-opt-in-notification-button-container']"));

            if(container.isDisplayed()){
                WebElement element = getDriver().findElement(By.xpath("//body//div[contains(text(),'Nanti saja')]"));
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enter_a_username(String name){
        WebElementFacade field_nama_user =  find(By.xpath(nama_user));

        field_nama_user.type(name);
    }

    public void enter_a_password(String pass){
        WebElementFacade field_password_user = find(By.xpath(password_user));

        field_password_user.type(pass);
    }

    public Boolean login_result(){
        WebElementFacade status = find(By.xpath(label));

        return status.isDisplayed();
    }

    public void login_now(){
        WebElement loginButton = getDriver().findElement(By.xpath(btn_for_login));
        loginButton.click();
    }

    public String search_result(String def){
        WebElement isFound = null;
        try {
            isFound = getDriver().findElement(By.xpath(search_result_found));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(isFound.isDisplayed()){
                WebElementFacade search_object = find(By.xpath("//body//*[@id='catalogProductListContentDiv']//*[div[contains(text(),'"+def+"')]]"));

                if(!search_object.isDisplayed()){
                    WebElementFacade search_is_not_found = find(By.xpath(".//*[@id='blibli-main-ctrl']/section/div//section/span[@class='search-result']//h1[contains(text(),'"+def+"')]"));

                    search_object =  search_is_not_found;
                }
                return search_object.getText();
            }else{
                return "There's something wrong with your query";
            }
    }

    public Boolean search_not_found(){
        WebElement isFound = null;
        try {
            isFound = getDriver().findElement(By.xpath("//body//*[@id='blibli-main-ctrl']/section/div//section"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isFound.isDisplayed();
        }
    }

    public void is_searching(String search_terms){
        WebElementFacade to_search = find(By.xpath(search_field));

        to_search.type(search_terms);
    }

    public void hit_enter_when_searching(){
        WebElementFacade to_search = find(By.xpath(search_field));

        to_search.sendKeys(Keys.RETURN);
    }

    public void hit_the_search_button(){
        WebElement btn_search = getDriver().findElement(By.xpath(search_button));

        try {
            btn_search.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
