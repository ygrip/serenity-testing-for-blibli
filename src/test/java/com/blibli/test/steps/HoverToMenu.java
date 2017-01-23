package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class HoverToMenu {
    @Steps
    User actor;

    @When("The user hover over a menu '$item_menu' and then click the submenu '$item_submenu'")
    public void hoverOverAMenu(String menu, String submenu){
        actor.userWantToHover(menu,submenu);
    }

    @Then("Thes user should directed to the '$page' page")
    public void userDirectedToNewTab(String page){
        actor.getTheNewTab(page);
    }

    @Then("The user choose to '$act' the first tab")
    public void userActAfterRedirected(String act){
        if(act.equals("close")){
            actor.closeTheTab();
        }else{
            actor.backToHomepage();
        }
    }
}
