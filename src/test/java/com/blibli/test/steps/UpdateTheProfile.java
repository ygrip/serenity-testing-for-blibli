package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class UpdateTheProfile {
    @Steps
    User actor;

    @Then("The user should be redirected to profile page")
    public void userIsInProfilePage(){
        actor.isInTheProfilePage();
    }

    @When("The user is inserting his fullname : '$fullname'")
    public void userIsInsertingHisFullname(String fullname){
        actor.fillProfileFullname(fullname);
    }

    @When("The user is inserting his day of birth : '$day' month of birth : '$month' Year of birth : '$year'")
    public void whenTheUserIsInsertingHisDayOfBirthMonthOfBirthYearOfBirth(String day, String month, String year){
        actor.fillProfileBirthday(day,month,year);
    }

    @When("The user is inserting his phone number : '$phone_number'")
    public void whenTheUserIsInsertingHisPhoneNumber(String phone_number){
        actor.fillProfilePhoneNumber(phone_number);
    }

    @When("The user is selecting gender '$gender'")
    public void whenTheUserIsSelectingGender(String gender){
        actor.fillProfileGender(gender);
    }

    @Then("the user is click save button")
    public void thenTheUserIsClickSaveButton(){
        actor.hitSaveButton();
    }

    @When("The user want to click the '$menu' in user profile page")
    public void menuToClick(String menu){
        actor.menuToClickInUserProfilePage(menu);
    }

    @When("The user is inputting new data in alamat <br> Nama Lengkap : '$nama' <br> Alamat : '$alamat' <br> Provinsi : '$prov' <br> Kota '$kot' <br> Kecamatan : '$kec' <br> Kelurahan : '$kel' <br> Email : '$em' <br> Handphone : '$hp'")
    public void inputNewAddress(String nama, String alamat, String prov, String kot, String kec, String kel, String email, String phone){
        actor.updateAlamatUser(nama,alamat,prov,kot,kec,kel,email,phone);
    }

    @Then("The user should see that their default address has been updated with the following details : <br> Nama Lengkap : '$nama' <br> Alamat : '$alamat' <br> Provinsi : '$prov' <br> Kota '$kot' <br> Kecamatan : '$kec' <br> Kelurahan : '$kel' <br> Email : '$em' <br> Handphone : '$hp'")
    public void userGetTheUpdatedDefaultAddress(String nama_lengkap, String alamat, String provinsi, String kota, String kecamatan, String kelurahan, String email, String handphone){
        actor.toCheckTheUpdateOnDefaultAlamat(nama_lengkap,alamat,provinsi,kota,kecamatan,kelurahan,email,handphone);
    }
}
