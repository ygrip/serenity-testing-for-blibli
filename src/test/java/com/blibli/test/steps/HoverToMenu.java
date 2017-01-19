package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class HoverToMenu {
    @Steps
    User actor;

    @When("The user hover over a menu and wanted to click the '$item' submenu")
    public void hover_over_a_menu(String item){
        actor.user_want_to_hover(item);
    }

}
