package com.app.gangof4.student.singletonP;

import org.junit.jupiter.api.Test;


public class SingletonPTest {

    @Test
    public void test() {
        LibrarySettingsManager settingsManager1 = LibrarySettingsManager.getSettingsManager();
        LibrarySettingsManager settingsManager2 = LibrarySettingsManager.getSettingsManager();

        System.out.println("Nesneler aynı mı ?");
        System.out.println("LibrarySettingsManager1 hashcode: " + settingsManager1.hashCode());
        System.out.println("LibrarySettingsManager2 hashcode: " + settingsManager2.hashCode());
        System.out.println("\n");

        LibraryApp merkezKutuphane = new LibraryApp("Merkez Kütüphane");
        merkezKutuphane.girisSaatiDegistir("08:00");
        merkezKutuphane.cikisSaatiDegistir("18:00");
        merkezKutuphane.saatleriGoster();

        LibraryApp libadiye = new LibraryApp("Libadiye Kütüphane");
        libadiye.saatleriGoster();

        LibraryApp maltepe = new LibraryApp("Maltepe Kütüphane");
        maltepe.saatleriGoster();

        merkezKutuphane.girisSaatiDegistir("09:00");
        merkezKutuphane.cikisSaatiDegistir("17:30");

        libadiye.saatleriGoster();
        maltepe.saatleriGoster();
    }
}
