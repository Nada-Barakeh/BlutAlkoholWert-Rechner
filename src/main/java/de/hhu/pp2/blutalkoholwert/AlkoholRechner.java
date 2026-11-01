package de.hhu.pp2.blutalkoholwert;

public class AlkoholRechner {
// rechnen:
//  Alkohol(g) = v(ml) x v(%)/100 x 0.8(g/ml) dann
// Blutalkoholwert(%) = Alkohol menge(g) / körpergewicht(kg) x red.Factor;


private static final double ALKOHOLDICHTE = 0.8;

public static double blutAlkoholWert(AlkoholForm alkohol){
    double alkoholMenge = 0.0;

    alkoholMenge += alkohol.getBier() * 0.05 * ALKOHOLDICHTE;
    alkoholMenge += alkohol.getWein() * 0.12 * ALKOHOLDICHTE;
    alkoholMenge += alkohol.getKorn() * 0.32 * ALKOHOLDICHTE;
    alkoholMenge += alkohol.getVodka() * 0.40 * ALKOHOLDICHTE;
    alkoholMenge += alkohol.getWhiskey() * 0.43 * ALKOHOLDICHTE;

    double redFaktor = alkohol.getGeschlecht().getRedfaktor();

    return alkoholMenge / (alkohol.getGewicht()*redFaktor);

}

    }
