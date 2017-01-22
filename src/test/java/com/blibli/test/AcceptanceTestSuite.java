package com.blibli.test;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class AcceptanceTestSuite extends SerenityStories {
    @Managed
    WebDriver driver;

    public AcceptanceTestSuite(){
//        runSerenity().inASingleSession();
    }

    @Override
    public List<String> storyPaths() {
        List<String> storiesToRun = new ArrayList<String>();

        storiesToRun.add(0, "stories/order_something_attempt/AddToCart.story");
//        storiesToRun.add(0,"stories/login_attempt/LoginTestOne.story");
//        storiesToRun.add(0,"stories/search_attempt/SearchTestOne.story");
//        storiesToRun.add(0,"stories/hover_element_attempt/HoverAnItem.story");
//        storiesToRun.add(0,"stories/open_mailinator_attempt/OpenMailinator.story");
//        storiesToRun.add(0,"stories/sign_up_attempt/SignUpTest.story");
//        storiesToRun.add(0,"stories/update_profile_attempt/UpdateStoryTest.story");
        return storiesToRun;
    }
}
