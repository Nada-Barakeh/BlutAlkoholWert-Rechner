package de.hhu.pp2.blutalkoholwert;

public enum Geschlecht {
    MÄNNER(0.7),
    FRAUEN(0.6);
    private final double redfaktor;

     Geschlecht(double redfaktor){
        this.redfaktor=redfaktor;
    }

    public double getRedfaktor() {
        return redfaktor;
    }
}
