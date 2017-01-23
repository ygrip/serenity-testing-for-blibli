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
           runSerenity().inASingleSession();
    }

    @Override
    public List<String> storyPaths() {
        List<String> storiesToRun = new ArrayList<String>();

        storiesToRun.add(0, "stories/order/AddToCart.story");
//        storiesToRun.add(0,"stories/login/LoginTestOne.story");
//        storiesToRun.add(0,"stories/search/SearchTestOne.story");
//        storiesToRun.add(0,"stories/hover/HoverAnItem.story");
//        storiesToRun.add(0,"stories/mailinator/OpenMailinator.story");
//        storiesToRun.add(0, "stories/register/SignUpTest.story");
//        storiesToRun.add(0, "stories/profile/UpdateStoryTest.story");
        return storiesToRun;
    }
}
