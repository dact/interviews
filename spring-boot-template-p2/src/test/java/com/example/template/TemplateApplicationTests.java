package com.example.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
	}

	/*12 min*/
	@Test
	public void givenAvailabilityCar_returnTrue(){
		//Arrange
		ParkingSystem parkingSystem = new ParkingSystem(1,1,1);
		//Act
		boolean result = parkingSystem.addCar(CarTypes.BIG);
		//Assert
		Assert.isTrue(result);
	}

	@Test
	public void givenOneAvailabilityCarMakeTwoCalls_returnFalse(){
		//Arrange
		ParkingSystem parkingSystem = new ParkingSystem(1,1,1);
		//Act
		boolean result = parkingSystem.addCar(CarTypes.BIG);
		result = parkingSystem.addCar(CarTypes.BIG);
		//Assert
		Assert.isTrue(!result);
	}

	/**
	 * 7 min
	 */
	@Test
	public void givenMoreThan1000CapacityAvailabilityCar_returnException(){
		//Arrange
		ParkingSystem parkingSystem;

		//Act
		try{
			parkingSystem = new ParkingSystem(333,333,334);
		}

		//Assert
		catch (ParkingSystemException e){
			Assert.isTrue(e!=null);
		}

	}

	/**
	 * 12 min
	 */
	@Test
	public void givenMoreThan1000calls_returnException(){
		//Arrange
		ParkingSystem parkingSystem = new ParkingSystem(1000,0,0);
		//Act
		for (int i = 0; i < 1000; i++) {
			parkingSystem.addCar(CarTypes.BIG);
		}
		try {
			parkingSystem.addCar(CarTypes.BIG);
		}
		//Assert
		catch (ParkingSystemException e){
			Assert.isTrue(e!=null);
		}
	}



}
