package com.app.gangof4.student.stateP;

import org.junit.jupiter.api.Test;

public class StatePTest {

    @Test
    public void statePTest() {
        System.out.println("State Pattern İşlemeye Başlıyor");

        ReservationContext reservationContext = new ReservationContext( "ÇNKL1915-78");
        reservationContext.printCurrentState();

        reservationContext.nextState();
        reservationContext.printCurrentState();

        reservationContext.cancelReservation();

        reservationContext.nextState();
        reservationContext.printCurrentState();



        reservationContext.nextState();
        reservationContext.printCurrentState();

        reservationContext.nextState();
        reservationContext.printCurrentState();

        reservationContext.cancelReservation();
    }

}
