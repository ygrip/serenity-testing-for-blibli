package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

/**
 * Created by Aditya on 19/01/2017.
 */
public class ClickAnItem {
    @Steps
    User actor;

    @When("i click the item")
    public void WhenIClickTheeItem(){
        actor.select_an_item();
    }
}
