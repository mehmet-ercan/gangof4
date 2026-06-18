package com.app.gangof4.student.stateP;

public class ConfirmedState extends ReservationState {
    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            context.setCurrentState(new CheckedInState());
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        return context.getReservationPartyCode() + " kodlu rezervasyonun ödemesi alındı.";
    }

    @Override
    public void cancelReservation(ReservationContext  context) {
        System.out.println("Rezervasyon bu adımda %50 geri ödeme ile iptal edilebilir. Müşteri onaylıyor mu? " +
                " -> (Onaylamadı, rezervasyona gelecek ...)");
        // cevap onaylıyor ise, duruma göre business işletilir (banka süreçleri tetiklenebilir. // iade faturası vs)
        // super.cancelReservation(context);
    }
}
