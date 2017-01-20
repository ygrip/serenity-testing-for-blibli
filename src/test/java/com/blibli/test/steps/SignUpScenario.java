package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class SignUpScenario {
    @Steps
    User actor;

    @When("The user clicked the sign up button")
    public void user_click_register(){
        actor.user_click_sign_up();
    }

    @When("The user inputing his identity <br> email : '$email' <br> password : '$pass'")
    public void user_is_inserting_identity(String email, String pass){
        actor.user_inputing_identity(email,pass);
    }

    @Then("The user shoud be redirected to the verification page or back to the mainpage(if already choose to verify or verify later)")
    public void redirected_to_verification_page(){
        actor.check_in_the_verification_page();
    }

    @Then("The user should be signed in and redirected to the website")
    public void is_the_user_signed_in(){
        actor.check_is_signed_up();
    }
}
