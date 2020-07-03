package com.exemplo.behavioral.chainofresponsability;

public class Transmission implements CarHandler {

    private CarHandler next;

    public Transmission(CarHandler next) {
        this.next = next;
    }

    @Override
    public void handleCar(Car car, String problem) {
        if(problem.equals("transmission")) {
            System.out.println("Transmission Solved! End");
        } else {
            if(next != null)
                next.handleCar(car, problem);
            else
                System.out.println("Handler chaind ended here!");
        }
    }
}
