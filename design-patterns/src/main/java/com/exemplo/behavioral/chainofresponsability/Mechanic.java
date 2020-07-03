package com.exemplo.behavioral.chainofresponsability;

public class Mechanic implements CarHandler {

    private CarHandler next;

    public Mechanic(CarHandler next) {
        this.next = next;
    }

    @Override
    public void handleCar(Car car, String problem) {
        if(problem.equals("mechanic")) {
            System.out.println("Mechanic solved! End");
        } else {
            if(next != null)
                next.handleCar(car, problem);
            else
                System.out.println("Handler chaind ended here!");
        }
    }
}
