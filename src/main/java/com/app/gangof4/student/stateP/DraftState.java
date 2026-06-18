package com.app.gangof4.student.stateP;

public class DraftState extends ReservationState {

    public DraftState() {;
    }

    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            context.setCurrentState(new PendingPaymentState());
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            return context.getReservationPartyCode() +  " kodlu rezervasyon sepete atıldı, \n " +
                    "Son kontrollerin yapılıp onaylanması bekleniyor.";
        } else return "";

    }

    @Override
    public void cancelReservation(ReservationContext context) {
        System.out.println("Rezervasyon iptal edildi.");
        super.cancelReservation(context);
    }
}
