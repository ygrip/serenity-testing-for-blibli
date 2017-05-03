package com.blibli.test.pages;

import com.blibli.test.models.OrderModels;
import com.blibli.test.models.UserModels;
import com.blibli.test.steps.actor.User;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

/**
 * Created by Yunaz on 1/17/2017.
 */
@DefaultUrl("http://www.blibli.com/")
public class BlibliPage extends PageObject{

    MobileAppsPage newtab;
    OrderModels order;

    //login button
    private String login = "//body//*[@id='gdn-login-registrasi']";
    private String idLogin = "gdn-login-registrasi";

    private String signup = "//body//*[@id='gdn-daftar']";
    private String idSignup = "gdn-daftar";

    private String btnForLogin ="//body//*[@id='gdn-submit-login']";

    private String namaUser = "//body//*[@id='loginEmail']";

    private String passwordUser = "//body//*[@id='loginPassword']";

    private String label = "//body//*[@id='gdnloginErrorLabel']";
    private String idLabel = "gdnloginErrorLabel";

    private String search_field = "//body//*[@id='autocomplete-wrapper']//input[@type='text']";

    private String search_button = "//body//*[@id='gdn-search-button']";

    private String search_result_found = "//body//*[@id='blibli-main-ctrl']/section/div/div[@id='catalogViewSection']";

    private String item = "//body//*[@id='catalogProductListContentDiv']/div[1]/div";

    private String recaptcha = ".//*[@id='recaptcha-anchor']//div[@class='recaptcha-checkbox-checkmark']";

    private String verifikasi_nanti = "//body//*[@id='gdn-pnv-later']";

    private String lanjutkan_verifikasi_nanti = "//body//*[@id='gdn-pnv-later-continue']";

    private String registrationPopup = "//body//*[@id='gdn-registration-form']/div";

    private String the_signed_user = "//body//*[@id='gdn-already-login-label']/strong";

    private String profile_url = "https://www.blibli.com/member/profile";

    private String full_name = "//body//*[@id='gdn-profile-name']";

    private String day_birth = "//body//*[@id='gdn-profile-day']";

    private String month_birth = "//body//*[@id='gdn-profile-month']";

    private String year_birth = "//body//*[@id='gdn-profile-year']";

    private String number_phone = "//body//*[@id='gdn-profile-phone']";

    private String klik_pria = "//body//*[@id='profileForm']/div[5]/div/div/span[1]/input";

    private String klik_wanita = "//body//*[@id='profileForm']/div[5]/div/div/span[2]/input";

    private String simpan_profile = "//body//*[@id='gdn-profile-submit']";

    private String al_btn_beli = "//body//*[@id='gdn-buy-now-top']";

    private String al_bag_belanja = "//body//*[@id='gdn-cart-button']/span[1]";

    private String al_section_beli = "//body//*[@id='gdn-buy-now-top']";

    private String al_tab_header_pesanan = "//body//*[@id='blibli-main-ctrl']//section//div[@class='tabs-header']//li";

    public void init(String url){
        WebDriver webDriver = getDriver();

        webDriver.navigate().to(url);
    }

    public void switchToTab(int tab){
        WebDriver webDriver = getDriver();
        ArrayList<String> newTab = new ArrayList<>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newTab.get(tab));
    }


    public void openNewTab(){
        WebDriver webDriver = getDriver();
        Actions action = new Actions(webDriver);

        WebElement body = webDriver.findElement(By.xpath("//body//*[a[@id='gdn-logo-blibli']]"));

        action.moveToElement(body).sendKeys(Keys.CONTROL, Keys.SHIFT).click(body).perform();

        ArrayList<String> newTab = new ArrayList<>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newTab.get(1));
    }

    public void userChooseToLogin(){
        WebDriver webDriver = getDriver();
        WebElement btn_login = webDriver.findElement(By.xpath(login));
        btn_login.click();
    }

    public void closePopUp(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        try {
            WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//*[@class='insider-opt-in-notification-button-container']")));

            if(container.isDisplayed()){
                WebElement element = webDriver.findElement(By.xpath("//body//div[contains(text(),'Nanti saja')]"));
                element.click();
            }else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enterAUsername(String name){
        WebElementFacade field_nama_user =  find(By.xpath(namaUser));

        field_nama_user.type(name);
    }

    public void enterAPassword(String pass){
        WebElementFacade field_password_user = find(By.xpath(passwordUser));

        field_password_user.type(pass);
    }

    public Boolean loginResult(){
        WebElementFacade status = find(By.xpath(label));

        return status.isDisplayed();
    }

    public void loginNow(){
        WebDriver webDriver = getDriver();
        WebElement loginButton = webDriver.findElement(By.xpath(btnForLogin));
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
            if(submenu.equals("Profil")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-profile']"))).click().build().perform();
            }else if(submenu.equals("Pesanan")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-order']"))).click().build().perform();
            }else if(submenu.equals("Rewards")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-rewards']"))).click().build().perform();
            }else if(submenu.equals("Wishlist")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-wishlist']"))).click().build().perform();
            }else if(submenu.equals("Voucher")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-voucher']"))).click().build().perform();
            }else if(submenu.equals("Ulasan")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-review']"))).click().build().perform();
            }else if(submenu.equals("Alamat")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-address']"))).click().build().perform();
            }else if(submenu.equals("Logout")){
                action.moveToElement(hover_menu).moveToElement(webDriver.findElement(By.xpath(".//*[@id='gdn-usermenu-logout']"))).click().build().perform();
            }
        }

    }

    public void scrollThePage(int x, int y) throws Exception {
        WebDriver webDriver = getDriver();

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public void scrollUntilTheVisibilityOf(String xpath) throws Exception {
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        try {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public String searchResult(String def){
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

    public Boolean searchNotFound(){
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

    public void isSearching(String search_terms){
        WebElementFacade to_search = find(By.xpath(search_field));

        to_search.type(search_terms);
    }

    public String getDefinitionsPage(String defPage){
        //WebDriver webDriver = getDriver();

        WebElementFacade definitionsListPage = find(By.xpath("//body//*[@id='catalogProductListContentDiv']//*[div[contains(text(),'"+defPage+"')]]"));

        return definitionsListPage.getText();
    }

    public void hitEnterWhenSearching(){
        WebElementFacade to_search = find(By.xpath(search_field));

        to_search.sendKeys(Keys.RETURN);
    }

    public void hitTheSearchButton(){
        WebDriver webDriver = getDriver();
        WebElement btn_search = webDriver.findElement(By.xpath(search_button));

        try {
            btn_search.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickAnItem(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        try {
            WebElement klikitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(item)));
            klikitem.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buyThatItemFor(int jumlah){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_section_beli))).isDisplayed()){
            String al_quantity = "//body//*[@id='gdn-input-quantity']";

            WebElement field_quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_quantity)));
            field_quantity.clear();
            field_quantity.sendKeys(String.valueOf(jumlah));

            WebElement btn_buy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_btn_beli)));
            btn_buy.click();
        }
    }

    public void processTheOrder(){
        WebDriver webDriver = getDriver();
        String url_chart = "https://www.blibli.com/cart";
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        Actions action = new Actions(webDriver);

        WebElement btn_bag = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath(al_bag_belanja))));
        action.moveToElement(btn_bag).click().build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(!webDriver.getCurrentUrl().equals(url_chart)){
            webDriver.navigate().to(url_chart);
        }

        String al_checkout = ".//*[@id='gdn-sb-page-continue-checkout']";

        WebElement btn_checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_checkout)));
//        try {
//            scrollUntilTheVisibilityOf(al_checkout);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        btn_checkout.click();
    }

    public void lanjutkanPembayaran(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        String al_lanjutkan = "//body//*[@id='gdn-next-step']";

        WebElement btn_lanjut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_lanjutkan)));
        try {
            scrollUntilTheVisibilityOf(al_lanjutkan);
        } catch (Exception e) {
            e.printStackTrace();
        }

        btn_lanjut.click();
    }

    public void pilihMetodePembayaran(String method, String opt, int sub_opt){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        String al_method_to_click = " ";
        String al_method_opt = " ";
        String al_method_sub_opt = " ";
        String al_btn_check_out = "//body//*[@id='gdn-submit-checkout']";
        int status = 0;

        if(method.equals("Internet Banking")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-e-banking']";
            al_method_opt = "//body//*[@id='gdn-payment-option-e-banking']";
        }
        else if(method.equals("Kartu Debit/Kredit")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-credit-card']";
            al_method_opt = "//body//*[@id='gdn-payment-option-credit-card']";
        }
        else if(method.equals("Cicilan 0%")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-cicilan']";
            al_method_opt = "//body//*[@id='gdn-payment-option-cicilan']";
            al_method_sub_opt = "//body//*[@id='payInstallmentTenorId']";
            status = 1;
        }
        else if(method.equals("Transfer")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-virtual-account']";
            al_method_opt = "//body//*[@id='gdn-payment-option-virtual-account-1']";
        }
        else if(method.equals("Uang Elektronik")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-e-money']";
            al_method_opt = "//body//*[@id='gdn-payment-option-e-money']";
        }
        else if(method.equals("Indomaret")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-indomaret']";
            status = 2;
        }
        else if(method.equals("Pos Indonesia")){
            al_method_to_click = "//body//*[@id='gdn-payment-group-pospay']";
            status = 2;
        }

        WebElement method_to_click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_method_to_click)));
        try {
            scrollUntilTheVisibilityOf(al_method_to_click);
        } catch (Exception e) {
            e.printStackTrace();
        }
        method_to_click.click();

        if(status==2){

        }else if(status == 1){
            WebElement method_opt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_method_opt)));
            try {
                scrollUntilTheVisibilityOf(al_method_opt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            method_opt.click();
            Select option = new Select(webDriver.findElement(By.xpath(al_method_opt)));
            option.selectByVisibleText(opt);

            WebElement method_sub_opt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_method_sub_opt)));
            method_sub_opt.click();
            Select sub_option = new Select(webDriver.findElement(By.xpath(al_method_sub_opt)));
            sub_option.selectByIndex(sub_opt);

        }else{
            WebElement method_opt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_method_opt)));
            try {
                scrollUntilTheVisibilityOf(al_method_opt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            method_opt.click();
            Select option = new Select(webDriver.findElement(By.xpath(al_method_opt)));
            option.selectByVisibleText(opt);
        }

        WebElement btn_check_out = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_btn_check_out)));
        try {
            scrollUntilTheVisibilityOf(al_btn_check_out);
            Coordinates coordinate = ((Locatable)btn_check_out).getCoordinates();
            coordinate.onPage();
            coordinate.inViewPort();
            btn_check_out.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDefinitionsofDescription(String descriptiontxt){
        //WebDriver webDriver = getDriver();

        WebElementFacade descriptionList = find(By.xpath(".//*[@id='blibli-main-ctrl']//section//div//h1[contains(text(),'"+descriptiontxt+"')]"));

        return descriptionList.getText();
    }

    public void click_recapthca(){
        WebElementFacade captcha = find(By.xpath(recaptcha));

        captcha.click();
    }

    public void verifikasiNanti(){
        WebDriver webDriver = getDriver();
        WebElementFacade later = find(By.xpath(verifikasi_nanti));

        later.click();

        WebDriverWait wait = new WebDriverWait(webDriver,10);

        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lanjutkan_verifikasi_nanti)));

        popup.click();
    }

    public Boolean isInVerificationPage(){
        WebDriver webDriver = getDriver();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return webDriver.getTitle().equals("Halaman Verifikasi | Blibli.com");
        }
    }

    public void userWantToSignUp(){
        WebDriver webDriver =  getDriver();

        WebElement btn_sign_up = webDriver.findElement(By.xpath(signup));

        btn_sign_up.click();
    }

    public void insertIdentity(String email, String pass){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement popup_register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationPopup)));

        if(popup_register.isDisplayed()){
            WebElementFacade email_address = find(By.xpath("//body//*[@id='registrationFormEmailAddress']"));
            WebElementFacade password_user = find(By.xpath("//body//*[@id='registrationFormPassword']"));
            WebElementFacade btn_daftar = find(By.xpath("//body//*[@id='gdn-submit-registration']"));

            email_address.type(email);
            password_user.type(pass);
            btn_daftar.click();
        }
    }

    public Boolean checkIsSignedIn(){
        WebDriver webDriver = getDriver();

        WebElement is_signed =  webDriver.findElement(By.xpath(the_signed_user));

        return is_signed.isDisplayed();
    }

    public Boolean userIsInTheProfilePage(){
        WebDriver webDriver = getDriver();

        return webDriver.getCurrentUrl().equals(profile_url);
    }

    public void fillFulname(String fullname){
        WebElementFacade name = find(By.xpath(full_name));

        name.type(fullname);
    }

    public void fillDateOfBirth(String day, String month, String year){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement field_dayBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(day_birth)));
        field_dayBirth.click();
        Select dayBirth = new Select(driver.findElement(By.xpath(day_birth)));
        //dayBirth.deselectAll();
        dayBirth.selectByVisibleText(day);

        WebElement field_monthBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(month_birth)));
        field_monthBirth.click();
        Select monthBirth = new Select(driver.findElement(By.xpath(month_birth)));
        //monthBirth.deselectAll();
        monthBirth.selectByVisibleText(month);

        WebElement field_yearBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(year_birth)));
        field_yearBirth.click();
        Select yearBirth = new Select(driver.findElement(By.xpath(year_birth)));
        //yearBirth.deselectAll();
        yearBirth.selectByVisibleText(year);
    }

    public void fillPhoneNumber(String phone_number){
        WebElementFacade phone = find(By.xpath(number_phone));

        phone.type(phone_number);
    }

    public void selectGender(String gender){
        if(gender.equals("male")){
            WebElementFacade klikmale = find(By.xpath(klik_pria));
            klikmale.click();
        }
        else if(gender.equals("female")){
            WebElementFacade klikfemale = find(By.xpath(klik_wanita));
            klikfemale.click();
        }
    }

    public void clickSaveButton(){
        WebElementFacade kliksaveprofile = find(By.xpath(simpan_profile));
        kliksaveprofile.click();
    }

    public void clickUserProfileSection(String menu){
        String menu_to_click = "//body//*[@id='blibli-main-ctrl']//section//ul//li//*[span[contains(text(),'"+menu+"')]]";

        WebDriver webDriver = getDriver();

        WebDriverWait wait = new WebDriverWait(webDriver,10);

        WebElement choosen_menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menu_to_click)));

        choosen_menu.click();
    }

    public void clickEditAlamat(String nama_lengkap, String alamat, String provinsi, String kota, String kecamatan, String kelurahan, String email, String handphone ){
        String to_click = "//body//*[@id='blibli-main-ctrl']/section//div//a[contains(text(),'Edit Alamat')]";
        String popup_edit_alamat = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']/div/div";

        WebDriver webDriver = getDriver();
        Actions action = new Actions(webDriver);

        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        WebElement link_toclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(to_click)));

        link_toclick.click();

        WebElement the_popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup_edit_alamat)));

        ((JavascriptExecutor)webDriver).executeScript("arguments[0].checked = true;", the_popup);

            String field_nama_lengkap = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//div//input[@name='firstName']";
            String field_alamat = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//div//textarea[@name='address']";
            String field_provinsi = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//*[label[contains(text(),'Provinsi')]]//select";
            String field_kota = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//*[label[contains(text(),'Kota')]]//select";
            String field_kecamatan = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//*[label[contains(text(),'Kecamatan')]]//select";
            String field_kelurahan = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//*[label[contains(text(),'Kelurahan')]]//select";
            String field_email = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//*[label[contains(text(),'Alamat Email')]]//input";
            String field_phone = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//input[@name='phone1']";
            String btn_submit = "//*[body[@class='modal-open']]//*[div[@class='modal fade in']]//*[@id='edit-address']//input[@type='submit']";

            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

            WebElement input_nama_lengkap = webDriver.findElement(By.xpath(field_nama_lengkap));
            ((JavascriptExecutor) webDriver).executeScript(js, input_nama_lengkap);
//            action.moveToElement(input_nama_lengkap).click().build().perform();
            input_nama_lengkap.clear();
            input_nama_lengkap.sendKeys(nama_lengkap);

            WebElement input_alamat = webDriver.findElement(By.xpath(field_alamat));
            ((JavascriptExecutor) webDriver).executeScript(js, input_alamat);
//            action.moveToElement(input_alamat).click().build().perform();
            input_alamat.clear();
            input_alamat.sendKeys(alamat);

            WebElement the_prov = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field_provinsi)));
            ((JavascriptExecutor) webDriver).executeScript(js, the_prov);
            if (the_prov.isDisplayed()) {
                the_prov.click();
                Select prov = new Select(webDriver.findElement(By.xpath(field_provinsi)));
                prov.selectByVisibleText(provinsi);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement the_city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field_kota)));
            ((JavascriptExecutor) webDriver).executeScript(js, the_city);
            if (the_city.isDisplayed()) {
                the_city.click();
                Select city = new Select(webDriver.findElement(By.xpath(field_kota)));
                city.selectByVisibleText(kota);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement the_kec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field_kecamatan)));
            ((JavascriptExecutor) webDriver).executeScript(js, the_kec);
            if (the_kec.isDisplayed()) {
                the_kec.click();
                Select kec = new Select(webDriver.findElement(By.xpath(field_kecamatan)));
                kec.selectByVisibleText(kecamatan);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement the_kel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field_kelurahan)));
            ((JavascriptExecutor) webDriver).executeScript(js, the_kel);
            if (the_kel.isDisplayed()) {
                the_kel.click();
                Select kel = new Select(webDriver.findElement(By.xpath(field_kelurahan)));
                kel.selectByVisibleText(kelurahan);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement input_email = webDriver.findElement(By.xpath(field_email));
            ((JavascriptExecutor) webDriver).executeScript(js, input_email);
//            action.moveToElement(input_email).click().build().perform();
            input_email.clear();
            input_email.sendKeys(email);

            WebElement input_phone = webDriver.findElement(By.xpath(field_phone));
            ((JavascriptExecutor) webDriver).executeScript(js, input_phone);
//            action.moveToElement(input_phone).click().build().perform();
            input_phone.clear();
            input_phone.sendKeys(handphone);

            WebElement btn_simpan = webDriver.findElement(By.xpath(btn_submit));
            btn_simpan.click();

    }

    public Boolean checkIsTheDefaultAlamatSaved(String nama_lengkap, String alamat, String provinsi, String kota, String kecamatan, String kelurahan, String email, String handphone){
        String component_to_wait = "//body//*[@id='blibli-main-ctrl']//section//*[div[@class='single-address default-address']]//div";
        Boolean result = false;
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement div_alamat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(component_to_wait)));

        if(div_alamat.isDisplayed()){
            Boolean check_name, check_alamat, check_prov, check_kot, check_kec, check_kel, check_em, check_ph;

            String al_first_name = "//body//*[@id='blibli-main-ctrl']//section//div//span[@class='ng-binding'][@ng-bind='defaultAddress.firstName']";
            String al_last_name = "//body//*[@id='blibli-main-ctrl']//section//div//label[@class='ng-binding'][@ng-bind='defaultAddress.lastName']";
            String al_address = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.address']";
            String al_kecamatan = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.kecamatan']";
            String al_kelurahan = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.kelurahan']";
            String al_city = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.city']";
            String al_state = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.state']";
            String al_phone = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.phone2']";
            String al_email = "//body//*[@id='blibli-main-ctrl']//section//div//span[@ng-bind='defaultAddress.email']";

            WebElement field_first_name = webDriver.findElement(By.xpath(al_first_name));
            WebElement field_last_name = webDriver.findElement(By.xpath(al_last_name));
            String namanya = field_first_name.getText()+" "+field_last_name.getText();
            check_name = namanya.equals(nama_lengkap);

            WebElement field_address = webDriver.findElement(By.xpath(al_address));
            check_alamat = field_address.getText().equals(alamat);

            WebElement field_kec =  webDriver.findElement(By.xpath(al_kecamatan));
            check_kec = field_kec.getText().equals(kecamatan);

            WebElement field_kel =  webDriver.findElement(By.xpath(al_kelurahan));
            check_kel = field_kel.getText().equals(kelurahan);

            WebElement field_kota =  webDriver.findElement(By.xpath(al_city));
            check_kot = field_kota.getText().equals(kota);

            WebElement field_prov =  webDriver.findElement(By.xpath(al_state));
            check_prov = field_prov.getText().equals(provinsi);

            WebElement field_phone =  webDriver.findElement(By.xpath(al_phone));
            check_ph = field_phone.getText().equals(handphone);

            WebElement field_email =  webDriver.findElement(By.xpath(al_email));
            check_em = field_email.getText().equals(email);

            if(check_name && check_alamat && check_kec && check_kel && check_kot && check_prov && check_em && check_ph){
                result = true;
            }
        }
        return result;
    }

    public void openPesananDetails(String choosen_tab){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        String al_order_tab =".//*[@id='blibli-main-ctrl']//section//div[@class='tabs-header']//li//*[span[contains(text(),'"+choosen_tab+"')]]";

        WebElement tab_to_click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_order_tab)));
        tab_to_click.click();
    }

    public Boolean checkTheOrderValidity(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        Boolean check_code_payment = false;
        Boolean check_code_transaction = false;

        String al_code_payment = "//body//*[@id='blibli-main-ctrl']//section//div[@class='order-detail']//div/span[@class='bankpayment']/strong";
        String al_code_transaction = "//body//*[@id='blibli-main-ctrl']//section//div[@class='order-detail']//div//*[label[contains(text(),'NO PESANAN:')]]//a";

        WebElement field_code_payment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_code_payment)));
        WebElement field_code_transaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_code_transaction)));

        check_code_payment = field_code_payment.getText().equals(OrderModels.no_rekening);
        check_code_transaction = field_code_transaction.getText().equals(OrderModels.no_pesanan);

        if(check_code_payment && check_code_transaction){
            return true;
        }
        else {
            return false;
        }

    }

    public void getTransactionDetails(){
        String al_code_payment = "//body//*[@id='blibli-main-ctrl']/section/div/section//div[@class='total-payment']//div//div[@class='layer']";
        String al_code_transaction = "//body//*[@id='blibli-main-ctrl']/section/div/section//div//span[@class='ordernumber']/strong";

        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement code_payment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_code_payment)));
        try {
            scrollUntilTheVisibilityOf(al_code_payment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement code_transaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_code_transaction)));
        try {
            scrollUntilTheVisibilityOf(al_code_transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OrderModels.no_rekening = code_payment.getText();
        OrderModels.no_pesanan = code_transaction.getText();

    }

    public void batalkanPesanan(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        String al_code_transaction = "//body//*[@id='gdn-history-cancel-order']";

        WebElement btn_to_click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_code_transaction)));
        try {
            scrollUntilTheVisibilityOf(al_code_transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn_to_click.click();

        String al_yes_btn = ".//*[@id='sweet-alert-confirm']";
        WebElement btn_yes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_yes_btn)));
        btn_yes.click();

    }
    public void checkTheEmailInbox(String email_to_check){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);

        WebElement input_field = webDriver.findElement(By.xpath("//body//*[@id='inboxfield']"));
        input_field.click();
        input_field.sendKeys(email_to_check);
        input_field.sendKeys(Keys.RETURN);
    }

    //Generating the link to cart bag
    private String idBtnBag = "gdn-cart-button";
    public WebElement getButtonBag(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idBtnBag)));
    }

    //Generating the link to wishlist
    private String idBtnWishList = "gdn-wishlist-header-text";
    public WebElement getButtonWishlist(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idBtnWishList)));
    }

    //Generating the search field
    public WebElement getSearchField() {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search_field)));
        return element;
    }

    //Generating the search button
    public WebElement getButtonSearch() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search_button)));
    }

    //Generating the search result page element
    public WebElement getSearchResultElement(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[@id='catalogProductListContentDiv']//*[div[contains(text(),'"+ UserModels.getUserSearch() +"')]]")));

        if(!element.isDisplayed()){
            WebElement notFound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//span[@class='search-result']//h1[contains(text(),'"+ UserModels.getUserSearch() +"')]")));

            if(notFound.isDisplayed()){
                element = notFound;
            }
            else {
                WebElement notValid = find(By.xpath("//body//*[@class='content-inner-section']"));
                element = notValid;
            }

        }
        return element;
    }

    //Generating browser driver for later usage
    public WebDriver getCurrentBrowser(){
        return getDriver();
    }

    //Generating the title of the current active page
    public String getCurrentTitle(){
        return getDriver().getTitle();
    }

    //Generating the url of the current active page
    public String getCurrentURL(){
        return getDriver().getCurrentUrl();
    }

    //Gnerating selenium actions for later usage
    public  Actions getCurrentAction(){
        return new Actions(getDriver());
    }

    //Generating the register link in the mainpage
    public WebElement getButtonRegister(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idSignup)));
    }

    //Generating the guide element
    private String idGuide = "gdn-panduan-belanja";
    public WebElement getHelpElement(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idGuide)));
    }

    //A class that handles the element in help menu box
    public class HelpMenuElement{
        private final WebElement bayar, kirim, kembali, lainnya;
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        //default constructor of help box element
        public HelpMenuElement() {
            this.bayar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='gdn-panduan-belanja']//div//ul//li//a[contains(text(),'Pembayaran')]")));
            this.kirim = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='gdn-panduan-belanja']//div//ul//li//a[contains(text(),'Pengiriman')]")));
            this.kembali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='gdn-panduan-belanja']//div//ul//li//a[contains(text(),'Pengembalian')]")));
            this.lainnya = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='gdn-panduan-belanja']//div//ul//li//a[contains(text(),'Panduan lainnya')]")));
        }

        //return element panduan pembayaran
        public WebElement getBayar() {
            return bayar;
        }
        //return element panduan pengiriman
        public WebElement getKirim() {
            return kirim;
        }
        //return element panduan pengembalian
        public WebElement getKembali() {
            return kembali;
        }
        //return element panduan lainnya
        public WebElement getLainnya() {
            return lainnya;
        }

    }

    //Generating the mobile app element
    private String idMobileApp = "mobile-app";
    public WebElement getMobileAppElement(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idMobileApp)));
    }

    //A class that handle the mobile app element
    public class MobileAppElements{
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        private final WebElement android, iOs, windows;

        public MobileAppElements() {
            this.android = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[@id='mobile-app']//li//*[div[contains(text(),'Android')]]")));
            this.iOs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[@id='mobile-app']//li//*[div[contains(text(),'iOS')]]")));
            this.windows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[@id='mobile-app']//li//*[div[contains(text(),'Windows')]]")));
        }
        public WebElement getAndroid() {
            return android;
        }

        public WebElement getiOs() {
            return iOs;
        }

        public WebElement getWindows() {
            return windows;
        }
    }

    //Generating the user signed in element
    private String idUserSignedIn = "gdn-already-login";
    public WebElement getUserSignedInElement(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserSignedIn)));
    }

    //A class that handle user menu box element
    private String idUserMenuBox = "gdn-usermenu-box";
    private String idUserProfileLink = "gdn-usermenu-profile";
    private String idUserOrderLink = "gdn-usermenu-order";
    private String idUserRewardLink = "gdn-usermenu-rewards";
    private String idUserWishListLink = "gdn-usermenu-wishlist";
    private String idUserVoucherLink = "gdn-usermenu-voucher";
    private String idUserReviewLink = "gdn-usermenu-review";
    private String idUserAddressLink = "gdn-usermenu-review";
    private String idUserLogoutLink = "gdn-usermenu-logout";

    public class UserMenuElements{
        private final WebElement menuBox, profile, order, reward, wishlist, voucher, review, address, logout;
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        //default constructor of UserMenu
        public UserMenuElements() {
            this.menuBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserMenuBox)));
            this.profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserProfileLink)));
            this.order = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserOrderLink)));
            this.reward = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserRewardLink)));
            this.wishlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserWishListLink)));
            this.voucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserVoucherLink)));
            this.review = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserReviewLink)));
            this.address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserAddressLink)));
            this.logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idUserLogoutLink)));
        }

        //return the user menu box
        public WebElement getMenuBox() {
            return menuBox;
        }

        //return the user profile menu link
        public WebElement getProfile() {
            return profile;
        }

        //return the user order menu link
        public WebElement getOrder() {
            return order;
        }

        //return the user reward menu link
        public WebElement getReward() {
            return reward;
        }

        //return the user wishlist menu link
        public WebElement getWishlist() {
            return wishlist;
        }

        //return the user voucher menu link
        public WebElement getVoucher() {
            return voucher;
        }

        //return the user review menu link
        public WebElement getReview() {
            return review;
        }

        //return the user address menu link
        public WebElement getAddress() {
            return address;
        }

        //return the user logout menu link
        public WebElement getLogout() {
            return logout;
        }

    }
    //Generating the user menu box

    //Generating the login link in the mainpage
    public WebElement getButtonLogin(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idLogin)));
    }

    private String idNamaUser = "loginEmail";
    private String idpasswordUser = "loginPassword";
    private String idbtnForLogin ="gdn-submit-login";

    //A class to handle the element for login uses
    public class LoginElement{
        private final WebElement fieldEmail, fieldPassword, btnLogin;

        //default constructor for login element
        public LoginElement() {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            this.fieldEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idNamaUser)));;
            this.fieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idpasswordUser)));
            this.btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idbtnForLogin)));
        }

        //return the webelement of email field in login popup
        public WebElement getFieldEmail() {
            return fieldEmail;
        }

        //return the webelement of the password field in login poopup
        public WebElement getFieldPassword() {
            return fieldPassword;
        }

        //return the webelement of the button login in login popup
        public WebElement getBtnLogin() {
            return btnLogin;
        }
    }

    private String idEmailRegistry = "registrationFormEmailAddress";
    private String idPasswordRegister = "registrationFormPassword";
    private String idButtonRegister = "gdn-submit-registration";

    //A class to handle the element for register uses
    public class  RegisterElement{
        private final WebElement fieldEmail, fieldPassword, btnRegister;

        //default constructor for register element
        public RegisterElement() {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            this.fieldEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idEmailRegistry)));;
            this.fieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idPasswordRegister)));
            this.btnRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idButtonRegister)));
        }

        //return the webelement of the email field in the register popup
        public WebElement getFieldEmail(){
            return fieldEmail;
        }

        //return the webelement of the password field in the register popup
        public WebElement getFieldPassword(){
            return fieldPassword;
        }

        //return the webelement of the button register in the register popup
        public WebElement getBtnRegister(){
            return btnRegister;
        }
    }

    //Generate the link used to verify later in verivication page
    private String idVerLink = "gdn-pnv-later";
    public WebElement getVerivicationLaterLink(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idVerLink)));
    }

    //Generate the button to verify later in the verivication later popup
    private String idVerPopup = "gdn-pnv-later-continue";
    public WebElement getVerivicationPopup(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idVerPopup)));
    }

    //A class that handles the element in profile page
    private String idNamaLengkap = "gdn-profile-name";
    private String idDayOfBirth = "gdn-profile-day";
    private String idMonthOfBirth = "gdn-profile-month";
    private String idYearOfBirth = "gdn-profile-year";
    private String idPhoneNumber = "gdn-profile-phone";
    private String idEmail = "gdn-profile-email";
    private String xpathGenderMale = "body//*[@id='profileForm']//div//span/input[@value ='Male']";
    private String xpathGenderFemale = "body//*[@id='profileForm']//div//span/input[@value ='Female']";
    private String idNewsLetterStatus = "gdnNewsletterStatus";
    private String idBtnChangePassword = "gdn-profile-change-password";
    private String idBtnSaveProfile = "gdn-profile-submit";

    public class ProfilePageElement{
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        private final WebElement fieldNamaLengkap, fieldDay, fieldMonth, fieldYear, fieldPhone, fieldEmail, checkMale, checkFemale, checkNewsLetter, btnChangePassword, btnSave;

        public ProfilePageElement() {
            this.fieldNamaLengkap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idNamaLengkap)));
            this.fieldDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idDayOfBirth)));
            this.fieldMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idMonthOfBirth)));
            this.fieldYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idYearOfBirth)));
            this.fieldPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idPhoneNumber)));
            this.fieldEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idEmail)));
            this.checkMale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpathGenderMale)));
            this.checkFemale = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xpathGenderFemale)));
            this.checkNewsLetter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idNewsLetterStatus)));
            this.btnChangePassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idBtnChangePassword)));
            this.btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idBtnSaveProfile)));
        }
        public WebElement getFieldNamaLengkap() {
            return fieldNamaLengkap;
        }

        public WebElement getFieldDay() {
            return fieldDay;
        }

        public WebElement getFieldMonth() {
            return fieldMonth;
        }

        public WebElement getFieldYear() {
            return fieldYear;
        }

        public WebElement getFieldPhone() {
            return fieldPhone;
        }

        public WebElement getFieldEmail() {
            return fieldEmail;
        }

        public WebElement getCheckMale() {
            return checkMale;
        }

        public WebElement getCheckFemale() {
            return checkFemale;
        }

        public WebElement getCheckNewsLetter() {
            return checkNewsLetter;
        }

        public WebElement getBtnChangePassword() {
            return btnChangePassword;
        }

        public WebElement getBtnSave() {
            return btnSave;
        }
    }

}
