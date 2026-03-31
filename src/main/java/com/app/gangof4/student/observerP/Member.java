package com.app.gangof4.student.observerP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member implements Listener {

    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + ": " + "Bana gruptan bir mesaj geldi > " + message);
    }
}
