package com.app.gangof4.student.observerP;

import com.app.gangof4.student.observerP.Group;
import com.app.gangof4.student.observerP.Member;
import org.junit.jupiter.api.Test;

public class ObserverPTest {

    @Test
    public void observerPTest() {
        System.out.println("Observer Pattern İşlemeye Başlıyor");

        Group indirimGrubu = new Group("Bulunmaz Fırsatlar");

        Member uye1 = new Member("Mehmet");
        indirimGrubu.joinGroup(uye1);
        Member uye2 = new Member("Salih");
        indirimGrubu.joinGroup(uye2);

        indirimGrubu.notifyGroupMembers("Crucial 3200Mhz CL22 RAM, Kısa Süreliğine %33 İndirime Girdi !");

        indirimGrubu.leaveGroup(uye1);
        indirimGrubu.leaveGroup(uye2);

        Member uye3 = new Member("Ali");
        indirimGrubu.joinGroup(uye3);

        indirimGrubu.notifyGroupMembers("Crucial 3200Mhz CL22 RAM, %33 İndirim Sona Erdi, " +
                "Diğer İndirimlerde Görüşmek Üzere !");

    }

}
