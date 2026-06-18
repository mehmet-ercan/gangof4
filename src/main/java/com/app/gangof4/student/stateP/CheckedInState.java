package com.app.gangof4.student.stateP;

public class CheckedInState extends ReservationState {
    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            context.setCurrentState(new CheckedOutState());
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        return "Müşteri otele giriş yaptı, odasına yerleşti.";
    }

    @Override
    public void cancelReservation(ReservationContext  context) {
        System.out.println("Bu adımda artık rezervasyon iptal edilemez. (Geri ödeme yapılmaz !)");
    }
}
