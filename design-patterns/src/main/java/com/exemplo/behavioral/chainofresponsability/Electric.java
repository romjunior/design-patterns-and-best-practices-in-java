package com.exemplo.behavioral.chainofresponsability;

public class Electric implements CarHandler{

    private CarHandler next;

    public Electric(CarHandler next) {
        this.next = next;
    }

    @Override
    public void handleCar(Car car, String problem) {
        if(problem.equals("electric")) {
            System.out.println("Electric solved! End");
        } else {
            if(next != null)
                next.handleCar(car, problem);
            else
                System.out.println("Handler chaind ended here!");
        }
    }
}
