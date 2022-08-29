package com.example.template;

public class ParkingSystem implements IParkingSystem{

    private static final int CAR_SLOT_CAPACITY = 1000;
    int carSlotCount=0;
    int bigAvaiblable;
    int mediumAvaiblable;
    int smallAvaiblable;
    public ParkingSystem(int big, int medium, int small) {
        if(big+medium+small>CAR_SLOT_CAPACITY)throw new ParkingSystemException("Slot capcity Exception exceded");
        this.bigAvaiblable = big;
        this.mediumAvaiblable = medium;
        this.smallAvaiblable = small;
    }


    @Override
    public boolean addCar(int carType) {
        if(carSlotCount==CAR_SLOT_CAPACITY)throw new ParkingSystemException("Car Slot count calls exception exceded");
        boolean result = false;

        switch (carType){
            case CarTypes.BIG:{
                if(bigAvaiblable>0){
                    bigAvaiblable--;
                    result=true;
                }
            }
            case CarTypes.MEDIUM:{
                if(mediumAvaiblable>0){
                    mediumAvaiblable--;
                    result=true;
                }
            }
            case CarTypes.SMALL:{
                if(smallAvaiblable>0){
                    smallAvaiblable--;
                    result=true;
                }
            }
        }

        if(result)carSlotCount++;
        return result;
    }
}
