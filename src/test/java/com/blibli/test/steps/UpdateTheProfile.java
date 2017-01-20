package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.yecht.Data;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class UpdateTheProfile {
    @Steps
    User actor;

    @Then("The user should be redirected to profile page")
    public void user_is_in_profile_page(){
        actor.is_in_the_profile_page();
    }

    @When("The user is inserting his fullname : '$fullname'")
    public void user_is_inserting_his_fullname(String fullname){
        actor.fill_profile_fullname(fullname);
    }

    @When("The user is inserting his day of birth : '$day' month of birth : '$month' Year of birth : '$year'")
    public void whenTheUserIsInsertingHisDayOfBirthMonthOfBirthYearOfBirth(String day, String month, String year){
        actor.fill_profile_birthday(day,month,year);
    }

    @When("The user is inserting his phone number : '$phone_number'")
    public void whenTheUserIsInsertingHisPhoneNumber(String phone_number){
        actor.fill_profile_phone_number(phone_number);
    }

    @When("The user is selecting gender '$gender'")
    public void whenTheUserIsSelectingGender(String gender){
        actor.fill_profile_gender(gender);
    }

    @Then("the user is click save button")
    public void thenTheUserIsClickSaveButton(){
        actor.hit_save_button();
    }
}