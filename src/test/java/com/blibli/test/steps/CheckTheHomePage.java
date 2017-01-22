package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import javax.xml.ws.WebServiceProvider;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class CheckTheHomePage {
    @Steps
    User actor;

    @Given("The user is on the '$page'")
    public void user_is_open_the_page(String page){
        actor.open_a_page(page);
    }

    @Then("The user should be in blibi homepage")
    public void should_be_on_the_main_page(){
        actor.open_a_page("https://www.blibli.com/");
    }
}
