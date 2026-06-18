package com.app.gangof4.student.stateP;

public class CheckedOutState extends ReservationState {
    @Override
    public void next(ReservationContext context) {
        if (!context.getReservationPartyCode().isEmpty()) {
            System.out.println(getStateStatus(context));
        } else {
            System.out.println("Sepette rezervasyon bulunmamaktadır, soraki adıma sepete rezervasyon eklenmeden geçilemez.");
        }
    }

    @Override
    public String getStateStatus(ReservationContext context) {
        return "Müşteri ayrıldı. Artık herhangi bir işlem yapılamaz.";
    }

    @Override
    public void cancelReservation(ReservationContext context) {
        System.out.println("Zaten müşteri çıkıkş yapmış, hizmetini de almış, iptal işlemi yanlışlıkla yapılmış olmalı !");
    }
}
