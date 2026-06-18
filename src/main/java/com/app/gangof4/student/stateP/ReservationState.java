package com.app.gangof4.student.stateP;

public abstract class ReservationState {

    public abstract void next(ReservationContext context);

    public abstract String getStateStatus(ReservationContext context);

    public void cancelReservation(ReservationContext context) {
        context.setCurrentState(new CancelledState());
        context.setReservationPartyCode("");
    }
}
