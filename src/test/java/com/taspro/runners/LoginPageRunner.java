package com.taspro.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/forgotpasswordpage.feature", glue = { "com.taspro.stepdefinations" })
public class LoginPageRunner extends AbstractTestNGCucumberTests {
	}
