package com.app.gangof4.student.stateP;

public class PendingPaymentState extends ReservationState {
    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            context.setCurrentState(new ConfirmedState());
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        return "Sepet onaylandı, ödeme bekleniyor.";
    }

    @Override
    public void cancelReservation(ReservationContext context) {
        System.out.println(context.getReservationPartyCode() + " kodlu rezervasyon iptal edildi.");
        super.cancelReservation(context);
    }
}
