package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class CheckTheHomePage {
    @Steps
    User actor;

    @Given("The user is on the '$page'")
    public void userIsOpenThePage(String page){
        actor.openAPage(page);
    }

    @Then("The user should be in blibi homepage")
    public void shouldBeOnTheMainPage(){
        actor.openAPage("https://www.blibli.com/");
    }
}
