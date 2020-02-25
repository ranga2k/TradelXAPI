/*package com.tradelxapp.junit.tradelxinfo;


import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.tradelxapp.utils.ReusableSpecifications;
import com.tradelxapp.cucumber.serenity.PetStoreSerenitySteps;
import com.tradelxapp.model.Status;
import com.tradelxapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetCRUDTest extends TestBase  {

	static Long categoryId = 1L;
	static String categoryName = "Dogs";
    static String name="Moonie";
	static String status=Status.AVAILABLE.getStatus();
	static Long tagId=100L;
	static String tagName="Prettydog";
	String[] photoUrls ={"www.dog.com"};
	static Long petId;
	
	@Steps
	PetStoreSerenitySteps steps;
	@Title("Create a  pet returns 200 status code on success")
	@Test
	public void test001(){
		steps.createPet(categoryId,categoryName,name,status,tagId,tagName,photoUrls)
		.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	

	@Title("Extract the PetID which was created and verify the added petdetails are correct")
	@Test
	public void test002(){
	HashMap<String,Object> value  =	steps.getPetinfobyName(name,status);	
	assertThat(value,hasValue(name));
	petId = (Long) value.get("id");
	}
	

	
	@Title("Update the pet name and verify the updated information")
	@Test
	public void test003(){
		
		
		name = name+"_Updated";
		status = Status.SOLD.getStatus();
		steps.updatePetName(petId,name,status);
		HashMap<String,Object> value = steps.getPetinfobyName(name,status);
		assertThat(value,hasValue(name));
		assertThat(value,hasValue(status));

	}
	
	@Title("Delete the pet and verify if the pet is deleted")
	@Test
	public void test004(){
		steps.deletePetId(petId);
		steps.getPetByID(petId).statusCode(404);
	}
}
*/