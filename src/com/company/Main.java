package com.company;

public class Main {
//todo: Treibstoffarten erben --> weniger Code (hoffentlich)
    //todo: tanken

    public static void main(String[] args) {

        Diesel diesel = new Diesel();
        Gas gas = new Gas();
        Super95 super95 = new Super95();
        SuperE10 superE10 = new SuperE10();
        Electricity electricity = new Electricity();

        Person carDriver = new Person("Peter");
        Car opel1 = new Car(Brand.OPEL, diesel, 300);
        carDriver.drivesCar(opel1);

        addNewGasStationToArray(carDriver);
        gasStationOffersFuel(diesel, gas, super95, superE10, electricity, carDriver);

        carDriver.searchGasStation(carDriver.car.typeOfDrive);
        carDriver.chooseNearestGasStation(carDriver.car.typeOfDrive);
        carDriver.chooseCheapestGasStation(carDriver.car.typeOfDrive);

    }


    private static void addNewGasStationToArray(Person carDriver) {
        carDriver.addToMyGasStations(new GasStation(Company.AGIP, "Dornbirn"));
        carDriver.addToMyGasStations(new GasStation(Company.OMV, "Dornbirn"));
        carDriver.addToMyGasStations(new GasStation(Company.SHELL, "Dornbirn"));
        carDriver.addToMyGasStations(new GasStation(Company.VKW, "Dornbirn"));
    }

    private static void gasStationOffersFuel(Diesel diesel, Gas gas, Super95 super95, SuperE10 superE10,
                                             Electricity electricity, Person carDriver) {
        for (int i = 0; i < carDriver.myGasStations.length; i++) {
            if(carDriver.myGasStations[i] != null) {
                if (carDriver.myGasStations[i].company == Company.AGIP) {
                    carDriver.myGasStations[i].offers(super95);
                    carDriver.myGasStations[i].offers(superE10);
                    carDriver.myGasStations[i].offers(diesel);
                } else if (carDriver.myGasStations[i].company == Company.OMV) {
                    carDriver.myGasStations[i].offers(super95);
                    carDriver.myGasStations[i].offers(diesel);
                    carDriver.myGasStations[i].offers(electricity);
                    carDriver.myGasStations[i].offers(gas);
                    carDriver.myGasStations[i].offers(superE10);
                } else if (carDriver.myGasStations[i].company == Company.SHELL) {
                    carDriver.myGasStations[i].offers(super95);
                    carDriver.myGasStations[i].offers(diesel);
                    carDriver.myGasStations[i].offers(gas);
                } else if (carDriver.myGasStations[i].company == Company.VKW) {
                    carDriver.myGasStations[i].offers(electricity);
                }
            }
        }
    }
}