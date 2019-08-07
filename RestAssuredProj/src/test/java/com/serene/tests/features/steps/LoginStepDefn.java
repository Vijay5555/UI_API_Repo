package com.serene.tests.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

import org.junit.runner.RunWith;



@RunWith(SerenityRunner.class)


public class LoginStepDefn {
	

	@Before
	public void setup()
	{
		System.out.println("Before start of the execution");
    	RestAssured.baseURI = "https://r8alxaspi1.execute-api.ap-southeast-2.amazonaws.com";

	}
	
	@After
	public void tearDown()
	{
		System.out.println("After end of the execution");
        RestAssured.reset();
	}
	@Steps
	LoginAPISteps loginAPI;

	@Given("^I provide login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_provide_username_with_password(String username,String password) {
		Serenity.setSessionVariable("username").to(username);
		Serenity.setSessionVariable("password").to(password);
		loginAPI.givenUserDetails(username,password);
	}

	@When("^I send request to login$")
	public void i_send_request_to_login() throws Throwable {
		loginAPI.postLoginRequest();
	}

	@Then("^login is successful$")
	public void login_is_successful() {
		String username = Serenity.sessionVariableCalled("username").toString();
		String password = Serenity.sessionVariableCalled("password").toString();
		loginAPI.verifyLoginSuccess(username,password);
		}
	
	@Then("^login failed$")
	public void login_failed() {
		String username = Serenity.sessionVariableCalled("username").toString();
		String password = Serenity.sessionVariableCalled("password").toString();
		loginAPI.verifyLoginFailure(username,password);
		}
	
	@Given("^I check the database to verify whether the username and password is present or not$")
	public void i_check_the_database_to_verify_whether_the_username_and_password_is_present_or_not() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^I check the data base$")
	public void i_check_the_data_base() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	}
}
