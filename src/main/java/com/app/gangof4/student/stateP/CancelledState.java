package com.app.gangof4.student.stateP;


public class CancelledState extends ReservationState {

    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            System.out.println("Rezervasyon iptal edildiğinden atanabilecek herhangi bir durum bulunmamaktadır.");
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        return "Rezervasyon iptal edildi.";
    }

    @Override
    public void cancelReservation(ReservationContext  context) {
        System.out.println("Rezervasyon zaten iptal edilmiş. Tekrar iptal edilemez." +
                "Yeni bir rezervasyon seçip sepete ekleyiniz.");
    }
}
