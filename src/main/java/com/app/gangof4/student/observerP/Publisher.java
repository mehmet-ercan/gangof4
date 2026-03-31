package com.app.gangof4.student.observerP;

public interface Publisher { // Observable
    void joinGroup(Member member); // subscribe
    void leaveGroup(Member member); // unsubscribe
    void notifyGroupMembers(String message); // fireEvent
}
