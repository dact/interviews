package com.example.template;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem implements IParkingSystem{

    private static final int CAR_SLOT_CAPACITY = 1000;
    int carSlotCountCalls = 0;


    //v2
    Map<Integer, Integer> mapSlot;

    public ParkingSystem(int big, int medium, int small) {
        if(big + medium + small > CAR_SLOT_CAPACITY ) throw new ParkingSystemException("Slot capcity Exception exceded");

        mapSlot = new HashMap<>();
        mapSlot.put(CarTypes.BIG,big);
        mapSlot.put(CarTypes.MEDIUM,medium);
        mapSlot.put(CarTypes.SMALL,small);

    }



    public boolean addCar(int carType) {
        if(carSlotCountCalls == CAR_SLOT_CAPACITY) throw new ParkingSystemException("Car Slot count calls exception exceded");
        boolean carAdded = false;

        if(mapSlot.get(carType) > 0){
            mapSlot.put( carType, mapSlot.get(carType) - 1 );
            carSlotCountCalls++;
            carAdded = true;
        }

        return carAdded;
    }

}
