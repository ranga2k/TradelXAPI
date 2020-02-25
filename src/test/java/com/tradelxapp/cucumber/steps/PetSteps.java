package com.tradelxapp.cucumber.steps;

import java.util.HashMap;

import com.tradelxapp.cucumber.serenity.PetStoreSerenitySteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PetSteps {
	
	static Long petId;
	
	@Steps
	PetStoreSerenitySteps steps;
	
	@When("^User sends the get request to the pet endpoint,they must get back valid 200 status code$")
	public void verifyStatusCode()
	{
		SerenityRest.rest()
		.given()
		.when()
		.get("18455632629489812001")
		.then()
		.statusCode(404);
	}
	
	@When("^I create a new pet with categoryId (.*),categoryName (.*),name (.*),status (.*),tagId (.*),tagName (.*),photoUrls (.*) options$")
	public void i_create_a_new_pet(Long categoryId,
			                       String categoryName,
			                       String name,
			                       String status,
			                       Long tagId,
			                       String tagName,
			                       String photoUrls) {
		
		   String[] photoUrl= {photoUrls};
		   steps.createPet(categoryId, categoryName, name,status, tagId, tagName,photoUrl);
	}
	
	
   @Then("^I verify the pet is created using name (.*) and status (.*)$")	
   public void verifyPetCreated(String name, String status)
   {
	   HashMap<String,Object> actualValue=  steps.getPetinfobyName(name,status);
	   assertThat(actualValue,hasValue(name));
	   assertThat(actualValue,hasValue(status));

   }
   
   @When("^Pick up newly created petname pretty,update name to pretty_Updated and status to available check$")
   public void pick_up_newly_created_petname_pretty_update_name_to_pretty_Updated_and_status_to_available_check(String name, String updatedname, String status) {
	   System.out.println("<=====================>");
		HashMap<String, Object> value = steps.getPetinfobyName(name, status);
		petId = (Long) value.get("id");
		   System.out.println("<=======petID==============>"+petId);

		steps.updatePetName(petId, name, status);
		HashMap<String, Object> value1 = steps.getPetinfobyName(name, status);
		assertThat(value1, hasValue(name));
		assertThat(value1, hasValue(status)); 
		}


   @Then("^I verify the pet is updated using name pretty_Updated and status available$")
   public void i_verify_the_pet_is_updated_using_name_pretty_Updated_and_status_available(String name, String status) {
	   HashMap<String,Object> actualValue=  steps.getPetinfobyName(name,status);
	   assertThat(actualValue,hasValue(name));
	   assertThat(actualValue,hasValue(status));
	   }
   
	@When("^Pick up newly created petname (.*),update name to (.*) and status to (.*) check$")
	public void update(String name, String updatedname, String status) {
		HashMap<String, Object> value = steps.getPetinfobyName(name, status);
		petId = (Long) value.get("id");
		steps.updatePetName(petId, updatedname, status);
		HashMap<String, Object> value1 = steps.getPetinfobyName(updatedname, status);
		assertThat(value1, hasValue(updatedname));
		assertThat(value1, hasValue(status));
		
	}
	
	
	   @Then("^I verify the pet is updated using name (.*) and status (.*)$")	
	   public void verifyUpdate(String name, String status)
	   {
		   HashMap<String,Object> actualValue=  steps.getPetinfobyName(name,status);
		   assertThat(actualValue,hasValue(name));
		   assertThat(actualValue,hasValue(status));

	   }
	   
	   
	   
	   @When("^I pick up newly updated pet name (.*), and status (.*) and delete the pet$") 
	   public void delete(String name, String status)
	   {
		    System.out.println("<=====Deleteing the pet=======>");
			HashMap<String, Object> value = steps.getPetinfobyName(name, status);
			petId = (Long) value.get("id");
		    steps.deletePetId(petId);
	   }
	   
	   @Then("^I verify the pet is deleted using by sending name (.*) and status (.*)$")
	   public void verifyDelete(String name, String status)
	   {
		   System.out.println("<=====verifying the pet has been deleted or not=======>");
		   steps.getPetByID(petId).statusCode(404);

	   }

}
