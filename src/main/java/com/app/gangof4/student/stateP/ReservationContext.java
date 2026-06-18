package com.app.gangof4.student.stateP;

// Draft            : taslak        > ürün sepette
// Pending Payment  : onay bekliyor > ürün sipariş edildi, ödeme bekleniyor
// Confirmed        : onaylandı     > ödeme yapıldı
// Checked-In       : giriş yapılıd > müşteri geldi, odaya gitti
// Checked-Out      : çıkış yapıldı > müşteri otelden ayrıldı
// Cancelled        : iptal edildi  > müşteri ürünü iptal etti

/**
 * state; Draft veya Pending Payment ise koşulsuz iptal edilir, diğer durumlarda red edilir
 * odaya ekstra hizmet eklenmesi, state sadece checked-in durumundaysa yapılır
 */

public class ReservationContext {
    private ReservationState currentState;
    private String reservationPartyCode = "";

    public ReservationContext(String code) {
        setReservationPartyCode(code);
        setCurrentState(new DraftState());
    }

    public void printCurrentState() {
        System.out.println(currentState.getStateStatus(this));
    }

    public ReservationState getCurrentState() {
        return currentState;
    }

    public  void setCurrentState(ReservationState state) {
        this.currentState = state;
    }

    public String getReservationPartyCode() {
        return reservationPartyCode;
    }

    public void setReservationPartyCode(String reservationPartyCode) {
        this.reservationPartyCode = reservationPartyCode;
    }

    public void nextState() {
        currentState.next(this);
    }

    public void cancelReservation() {
        currentState.cancelReservation(this);
    }

}
