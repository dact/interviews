package com.example.template;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
	}


	/*
	* 17 min
	* */
	@Test
	public void given2Array_ReturnListIntersection(){
		//Arrange
		ArrayOperations arrayOperations = new ArrayOperations();
		//Act
		List<Integer> resultIntersection = arrayOperations.intersection(new int[]{4, 9, 5},new int[]{9,4,9,8,4});
		//Assert
		Assert.notNull(resultIntersection);
	}

	/*
	 * 7 min
	 * */
	@Test
	public void given2ArrayWithLengthMajor1000_ReturException(){
		//Arrange
		ArrayOperations arrayOperations = new ArrayOperations();
		//Act
		try{
			List<Integer> resultIntersection = arrayOperations.intersection(new int[]{4, 9, 5},new int[1000]);
		}
		catch(ArrayOperationsException e){
			Assert.isTrue(true);
		}
		//Assert

	}

	/*
	3 min
	 */
	@Test
	public void given2ArrayWithElementMajor1000_ReturException(){
		//Arrange
		ArrayOperations arrayOperations = new ArrayOperations();
		//Act
		try{
			List<Integer> resultIntersection = arrayOperations.intersection(new int[]{1001, 9, 5},new int[]{9,4,9,8,4});
		}
		catch(ArrayOperationsException e){
			Assert.isTrue(true);
		}
		//Assert

	}

}
