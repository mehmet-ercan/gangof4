package com.app.gangof4.student.observerP;

import java.util.HashSet;
import java.util.Set;

public class Group implements Publisher {

    private final Set<Member> members = new HashSet<>();

    public Group(String name) {
        System.out.println(name + " Whatsapp Grubu Oluşturuldu.");
    }

    private void attachMember(Member member) {
        this.members.add(member);
        System.out.println("Gruba yeni bir üye eklendi: " + member.getName());
    }

    private void detachMember(Member member) {
        this.members.remove(member);
        System.out.println("Grubun bir üyesi çıkarıldı: " + member.getName());
    }

    @Override
    public void notifyGroupMembers(String message) {
        members.forEach(member -> member.update(message));
    }

    @Override
    public void joinGroup (Member member) {
        this.attachMember(member);
    }

    @Override
     public void leaveGroup (Member member) {
        this.detachMember(member);
    }
}
