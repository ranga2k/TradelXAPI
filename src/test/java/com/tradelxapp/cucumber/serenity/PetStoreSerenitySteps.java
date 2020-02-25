package com.tradelxapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.HashMap;

import org.assertj.core.api.AssertDelegateTarget;

import com.tradelxapp.model.CategoryClass;
import com.tradelxapp.model.PetDetailsClass;
import com.tradelxapp.model.TagsClass;
import com.tradelxapp.utils.ReusableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetStoreSerenitySteps {
	
	@Step("Creating the pet using categoryId:{0},categoryName:{1},name:{2},photoUrls:{3},tagsId:{5},"
			+ "tagsName:{6},status:{4}"
			+ " On sucess the status code should be 200")
	public ValidatableResponse createPet
	                    (Long categoryId,
	                    String categoryName,
	                    String name,
	                    String status,
	                    Long tagId,
	                    String tagName,
	                    String[] photoUrls
	                                 ) {		
		ArrayList<TagsClass> tagsList = new ArrayList();
		tagsList.add(new TagsClass(tagId,tagName));
		
		CategoryClass categoryClass= new CategoryClass(categoryId,categoryName);
		
		PetDetailsClass petdetails = new PetDetailsClass(categoryClass, tagsList, name,photoUrls, status );	
	 	return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
	    .when()
		.body(petdetails)
		.post()
		.then();
	}
	
	
	
	@Step("Getting the pet information using the petId:{0}")
	public HashMap<String,Object> getPetinfobyName(String name,String status)
	{
	
		String val1="findAll{it.name=='";
		String val2="'}.get(0)";
		//System.out.println("<======checking findAll=====>"+val1+name+val2);
		return SerenityRest.rest().given()
		.when()
		.get("/findByStatus?status="+status)
		.then()
		.statusCode(200)
		.extract()
		.path(val1+name+val2);
	}

	
	@Step("Getting the student information with first name:{0}")
	public HashMap<String,Object> getStudentInfoByFirstName(String firstName)
	{
		String val1="findAll{it.firstName=='";
		String val2="'}.get(0)";
		return SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.statusCode(200)
		.extract()
		.path(val1+firstName+val2);

	}
	
	
	@Step("Updating the petname using petid : {0} ,pet name:{1}")
	public ValidatableResponse updatePetName
	                    (
	                    Long petId,		
	                     String name,
	                     String status
	                    ) {
		
		PetDetailsClass pet = new PetDetailsClass(name,petId,status);
		return SerenityRest.rest().given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
	    .when()
		.body(pet)
		.put()
		.then()
		.statusCode(200);
	}


	
	@Step("Deleting the pet details  using Id :{0}")
	public void deletePetId(Long petId){
		SerenityRest.rest().given().when().delete("/"+petId);
	}
			
	
	@Step("Getting the the pet details  with Id :{0}")
	public ValidatableResponse getPetByID(Long petId)
	{
	return SerenityRest.rest().given().when().get("/" +petId).then();
}
	
}
