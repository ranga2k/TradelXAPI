package com.tradelxapp.cucumber;

import org.junit.runner.RunWith;
import com.tradelxapp.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/")
public class PetStoreRunner extends TestBase{
	

	

}
