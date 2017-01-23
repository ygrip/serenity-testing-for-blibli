package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;

/**
 * Created by Aditya on 19/01/2017.
 */
public class ItemDescription {
    @Steps
    User actor;

    @Then("they should see the item description contains '$defin'")
    public void ThenTheyShouldSeeTheItemDescriptionContains(String defin){
        actor.shouldSeeDescription(defin);
    }
}
