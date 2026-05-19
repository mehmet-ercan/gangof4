package com.app.gangof4.student.singletonP;

public class LibraryApp {

    private final String libraryName;

    public LibraryApp(String libraryName) {
        this.libraryName = libraryName;
    }

    public void girisSaatiDegistir(String yeniSaat) {
        LibrarySettingsManager settingsManager = LibrarySettingsManager.getSettingsManager();
        settingsManager.girisSaatiDegistir(yeniSaat);
        settingsManager.ayarlariGoster();
    }

    public void cikisSaatiDegistir(String yeniSaat) {
        LibrarySettingsManager settingsManager = LibrarySettingsManager.getSettingsManager();
        settingsManager.cikisSaatiDegistir(yeniSaat);
        settingsManager.ayarlariGoster();
    }

    public void saatleriGoster() {
        LibrarySettingsManager settingsManager = LibrarySettingsManager.getSettingsManager();
        System.out.println("\n " + libraryName + " ayarlari aşağıdaki gibidir: " + settingsManager.ayarlariGoster());
    }
}
