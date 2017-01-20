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

    @When("The user hover over a menu and wanted to click the menu '$item_menu' and then click the submenu '$item_submenu'")
    public void hover_over_a_menu(String menu, String submenu){
        actor.user_want_to_hover(menu,submenu);
    }

    @Then("Thes user should directed to the '$page' page")
    public void user_directed_to_new_tab(String page){
        actor.get_the_new_tab(page);
    }

    @Then("The user choose to '$act' the first tab")
    public void user_act_after_redirected(String act){
        if(act.equals("close")){
            actor.close_the_tab();
        }else{
            actor.back_to_homepage();
        }
    }
}
