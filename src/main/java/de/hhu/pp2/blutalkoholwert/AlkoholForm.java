package de.hhu.pp2.blutalkoholwert;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class AlkoholForm {

    @NotNull(message = "Bitte Gechlecht wählen")
    private Geschlecht geschlecht;

    @NotNull(message = "Gewicht darf nicht leer sein")
    @DecimalMin(value = "1.0" ,message = "Gewicht muss +ve sein")
    private  double gewicht;

    @DecimalMin(value = "0.0" , message = "mege darf nicht -ve sein")
    private double bier;

    @DecimalMin(value = "0.0" , message = "mege darf nicht -ve sein")
    private double wein;

    @DecimalMin(value = "0.0" , message = "mege darf nicht -ve sein")
    private double korn;

    @DecimalMin(value = "0.0" , message = "mege darf nicht -ve sein")
    private double vodka;

    @DecimalMin(value = "0.0" , message = "mege darf nicht -ve sein")
    private double whiskey;


    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public double getGewicht() {
        return gewicht;
    }

    public double getBier() {
        return bier;
    }

    public double getWein() {
        return wein;
    }

    public double getKorn() {
        return korn;
    }

    public double getVodka() {
        return vodka;
    }

    public double getWhiskey() {
        return whiskey;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public void setBier(double bier) {
        this.bier = bier;
    }

    public void setWein(double wein) {
        this.wein = wein;
    }

    public void setKorn(double korn) {
        this.korn = korn;
    }

    public void setVodka(double vodka) {
        this.vodka = vodka;
    }

    public void setWhiskey(double whiskey) {
        this.whiskey = whiskey;
    }
}
