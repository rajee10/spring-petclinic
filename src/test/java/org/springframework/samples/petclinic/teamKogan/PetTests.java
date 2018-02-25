package org.springframework.samples.petclinic.teamkogan.PetTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.samples.petclinic.owner.VisitController;


public class PetTests {
	
	@Test
	public void PetBirthDateTest() {
		
	//initializing Date object
	final Date birthDate = new Date();
	birthDate.setDate(19920809);
	
	//creating mock Pet object
	Pet mockPet=mock(Pet.class);
	
	//stub mockPet's birthdate to return 19920809
	when(mockPet.getBirthDate()).thenReturn(birthDate);
	
	
	//actual method call
	Pet realPet=new Pet();
	realPet.setBirthDate(birthDate);

	//assert
	assertEquals(realPet.getBirthDate(), mockPet.getBirthDate());
	
	//verifying use
	verify(mockPet).getBirthDate();
	}
	
	@Test
	public void getOwnersPetsTest() {
		
	//create mock of Owner
	Owner mockOwner=mock(Owner.class);
	
	//initializing new pet and List
	Pet pet=new Pet();
	List<Pet> sortedPets = new ArrayList<>();
	sortedPets.add(pet);
	sortedPets=Collections.unmodifiableList(sortedPets);
	
	//stub getPets() to return sortedPets list
	when(mockOwner.getPets()).thenReturn(sortedPets);
	
	//call the class under test
	Owner owner1=new Owner();
	owner1.addPet(pet);
	
	//assert what was returned
	assertEquals(owner1.getPets(), mockOwner.getPets());
	
	//verifying use
	verify(mockOwner).getPets();
	}
}
