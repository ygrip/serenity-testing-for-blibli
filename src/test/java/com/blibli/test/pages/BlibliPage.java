package com.blibli.test.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Yunaz on 1/17/2017.
 */
@DefaultUrl("http://www.blibli.com/")
public class BlibliPage extends PageObject{

    MobileAppsPage newtab;
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

    private String item = "//body//*[@id='catalogProductListContentDiv']/div[2]/div";

    private String recaptcha = ".//*[@id='recaptcha-anchor']//div[@class='recaptcha-checkbox-checkmark']";

    private String verifikasi_nanti = "//body//*[@id='gdn-pnv-later']";

    private String lanjutkan_verifikasi_nanti = "//body//*[@id='gdn-pnv-later-continue']";

    private String registration_popup = "//body//*[@id='gdn-registration-form']/div";

    private String the_signed_user = "//body//*[@id='gdn-already-login-label']/strong";

    private String profile_url = "https://www.blibli.com/member/profile";

    public void init(){
        WebDriver webDriver = getDriver();

        webDriver.navigate().to("http://www.blibli.com/");
    }

    public void open_new_tab(){
        WebDriver webDriver = getDriver();
        Actions action = new Actions(webDriver);

        WebElement body = webDriver.findElement(By.xpath("//body//*[a[@id='gdn-logo-blibli']]"));

        action.moveToElement(body).sendKeys(Keys.CONTROL, Keys.SHIFT).click(body).perform();

        ArrayList<String> newTab = new ArrayList<>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newTab.get(1));
    }

    public void user_choose_to_login(){
        WebDriver webDriver = getDriver();
        WebElement btn_login = webDriver.findElement(By.xpath(login));
        btn_login.click();
    }

    public void closePopUp(){
        WebDriver webDriver = getDriver();
        try {
            WebElement container = webDriver.findElement(By.xpath("//body//*[@class='insider-opt-in-notification-button-container']"));

            if(container.isDisplayed()){
                WebElement element = webDriver.findElement(By.xpath("//body//div[contains(text(),'Nanti saja')]"));
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
        WebDriver webDriver = getDriver();
        WebElement loginButton = webDriver.findElement(By.xpath(btn_for_login));
        Actions action = new Actions(webDriver);


        /*String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";


        ((JavascriptExecutor)webdriver).executeScript(javaScript, loginButton);*/

        action.moveToElement(loginButton).perform();
        loginButton.click();
    }

    public void hovering(String menu, String submenu){
        WebDriver webDriver = getDriver();
        Actions action = new Actions(webDriver);
        WebElement hover_menu;
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        if(menu.equals("Mobile")){
            hover_menu = webDriver.findElement(By.xpath("//body//*[@id='mobile-app']/span"));
            String oldTab =  webDriver.getWindowHandle();
            action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath("//body//*[@id='mobile-app']//li//*[div[contains(text(),'"+submenu+"')]]"))).click().build().perform();

            ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());
            newTab.remove(oldTab);

            if(waitForNewTab(webDriver,500)){
                webDriver.switchTo().window(newTab.get(0));
            }
        }else if(menu.equals("User")){
            hover_menu = webDriver.findElement(By.xpath(".//*[@id='gdn-already-login']"));

            action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath("//body//*[@id='gdn-usermenu-box']/ul//li//a[contains(text(),'"+submenu+"')]"))).click().build().perform();
        }

    }

    public void scroll_the_page(int x, int y) throws Exception {
        WebDriver webDriver = getDriver();

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public static boolean waitForNewTab(WebDriver driver,int timeout){
        boolean check = false;
        int count = 0;
        while(!check){
            try {
                Set<String> winHandle = driver.getWindowHandles();
                if(winHandle.size() > 1){
                    check = true;
                    return check;
                }
                Thread.sleep(1000);
                count++;
                if(count > timeout){
                    return check;
                }
            } catch (Exception e) {
            }
        }
        return check;
    }

    public Boolean checkHome(){
        WebDriver webDriver = getDriver();
        return webDriver.getCurrentUrl().equals("https://www.blibli.com");
    }

    public String search_result(String def){
        WebDriver webDriver = getDriver();
        WebElement isFound = null;
        try {
            isFound = webDriver.findElement(By.xpath(search_result_found));
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
        WebDriver webDriver = getDriver();
        try {
            isFound = webDriver.findElement(By.xpath("//body//*[@id='blibli-main-ctrl']/section/div//section"));
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

    public String getDefinitionsPage(String defPage){
        //WebDriver webDriver = getDriver();

        WebElementFacade definitionsListPage = find(By.xpath("//body//*[@id='catalogProductListContentDiv']//*[div[contains(text(),'"+defPage+"')]]"));

        return definitionsListPage.getText();
    }

    public void hit_enter_when_searching(){
        WebElementFacade to_search = find(By.xpath(search_field));

        to_search.sendKeys(Keys.RETURN);
    }

    public void hit_the_search_button(){
        WebDriver webDriver = getDriver();
        WebElement btn_search = webDriver.findElement(By.xpath(search_button));

        try {
            btn_search.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_an_item(){
        WebElementFacade klikitem = find(By.xpath(item));
        klikitem.click();
    }

    public String getDefinitionsofDescription(String descriptiontxt){
        //WebDriver webDriver = getDriver();

        WebElementFacade descriptionList = find(By.xpath("//body//*[@id='blibli-main-ctrl']//section//div//section//h1[contains(text(),'"+descriptiontxt+"')]"));

        return descriptionList.getText();
    }

    public void click_recapthca(){
        WebElementFacade captcha = find(By.xpath(recaptcha));

        captcha.click();
    }

    public void verifikasi_nanti(){
        WebDriver webDriver = getDriver();
        WebElementFacade later = find(By.xpath(verifikasi_nanti));

        later.click();

        WebDriverWait wait = new WebDriverWait(webDriver,10);

        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lanjutkan_verifikasi_nanti)));

        popup.click();
    }

    public Boolean is_in_verification_page(){
        WebDriver webDriver = getDriver();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return webDriver.getTitle().equals("Halaman Verifikasi | Blibli.com");
        }
    }

    public void user_want_to_sign_up(){
        WebDriver webDriver =  getDriver();

        WebElement btn_sign_up = webDriver.findElement(By.xpath(signup));

        btn_sign_up.click();
    }

    public void insert_identity(String email, String pass){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement popup_register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registration_popup)));

        if(popup_register.isDisplayed()){
            WebElementFacade email_address = find(By.xpath("//body//*[@id='registrationFormEmailAddress']"));
            WebElementFacade password_user = find(By.xpath("//body//*[@id='registrationFormPassword']"));
            WebElementFacade btn_daftar = find(By.xpath("//body//*[@id='gdn-submit-registration']"));

            email_address.type(email);
            password_user.type(pass);
            btn_daftar.click();
        }
    }

    public Boolean check_is_signed_in(){
        WebDriver webDriver = getDriver();

        WebElement is_signed =  webDriver.findElement(By.xpath(the_signed_user));

        return is_signed.isDisplayed();
    }

    public Boolean user_is_in_the_profile_page(){
        WebDriver webDriver = getDriver();

        return webDriver.getCurrentUrl().equals(profile_url);
    }

    // this comment use for testing commit
}
