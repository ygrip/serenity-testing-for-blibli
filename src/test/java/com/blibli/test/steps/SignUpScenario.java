package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class SignUpScenario {
    @Steps
    User actor;

    @When("The user clicked the sign up button")
    public void userClickRegister(){
        actor.userClickSignUp();
    }

    @When("The user inputing his identity <br> email : '$email' <br> password : '$pass'")
    public void userIsInsertingIdentity(String email, String pass){
        actor.userInputingIdentity(email,pass);
    }

    @Then("The user shoud be redirected to the verification page or back to the mainpage(if already choose to verify or verify later)")
    public void redirectedToVerificationPage(){
        actor.checkInTheVerificationPage();
    }

    @Given("The user have been signed in and is in the website")
    public void is_the_user_signed_in(){
        actor.checkIsSignedUp();
    }
}
