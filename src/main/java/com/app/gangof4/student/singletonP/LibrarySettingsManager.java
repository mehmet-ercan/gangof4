package com.app.gangof4.student.singletonP;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LibrarySettingsManager {

    private static LibrarySettingsManager librarySettingsManager;
    private String girisSaati;
    private String cikisSaati;

    public static LibrarySettingsManager getSettingsManager() {
        if (librarySettingsManager == null) {
            librarySettingsManager = new LibrarySettingsManager();
        }

        return librarySettingsManager;
    }

    private LibrarySettingsManager() {
    }

    public void girisSaatiDegistir(String yeniSaat) {
        this.girisSaati = yeniSaat;
    }

    public void cikisSaatiDegistir(String yeniSaat) {
        this.cikisSaati = yeniSaat;
    }

    public String ayarlariGoster() {
        return "\nGiriş saati: " + girisSaati +
                "\nÇıkış saati: " + cikisSaati + "\n";
    }
}
