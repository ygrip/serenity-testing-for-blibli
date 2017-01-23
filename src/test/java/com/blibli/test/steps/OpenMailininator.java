package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class OpenMailininator {
    @Steps
    User actor;

    @When("User want to open the mailinator page")
    public void openTheMailinatorPage(){
        actor.userOpenMailinator();
    }

    @Then("The user should see the mailinator web page")
    public void checkIsTheMailinator(){
        actor.isTheMailinator();
    }

    @When("The user want to open inbox in their account : '$account'")
    public void openInbox(String email){
        actor.openMailUser(email);
    }

    @Then("The user want to delete the email")
    public void delete_mail_in_mailinator(){
        actor.deleteEmail();
    }
}
