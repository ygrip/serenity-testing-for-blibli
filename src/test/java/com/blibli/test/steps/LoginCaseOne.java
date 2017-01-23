package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/17/2017.
 */
public class LoginCaseOne {
    @Steps
    User actor;

    @When("The user is entering his credentials : <br> username : '$name' and password : '$pass'")
    public void userEnteringCredenials(String name, String pass){
        actor.userAttemptToLogin(name,pass);
    }

    @Then("The user should see the error result")
    public void loginAttemptResult(){
        actor.seeTheResult();
    }
}
