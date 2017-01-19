package com.blibli.test;

import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.jbehave.UTF8StoryLoader;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class AcceptanceTestSuite extends SerenityStories {
    @Managed
    WebDriver driver;

    public AcceptanceTestSuite(){
        runSerenity().inASingleSession();
    }

    @Override
    public List<String> storyPaths() {
        List<String> storiesToRun = new ArrayList<String>();

        storiesToRun.add(0,"stories/hover_element_attempt/HoverAnItem.story");

        return storiesToRun;
    }
}
