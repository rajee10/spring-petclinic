package org.springframework.samples.petclinic.owner;

public class OwnerStorage {

	int size = 999;
	Owner[] ownerList;
	
	public OwnerStorage() {
		ownerList = new Owner[size];
	}
	
 	public void forklift() {

 		
 	}

 	public int checkConsistency() {
 		int inconsistencies = 0;
 		
 		for(int i = 0; i < 999; i++)
 		{
 	//	Owner expected = 
 		Owner actual = ownerList[i];
 		
 		if(!expected.equals(actual)) {
 			{
 				ownerList[i] = expected;
 				
 				inconsistencies++;
 				violation(i, expected, actual);
 			}
 		}
 		}
 		
 		return inconsistencies;
 	}

 	private void violation(int i, Owner expected, Owner actual)
 	{
 		System.out.println("Consistency Violation! \n" + "i = " + i + "\n\t expected = " + 
 				expected.toString() + "\n\t actual = " + actual.toString());
 	}
}
