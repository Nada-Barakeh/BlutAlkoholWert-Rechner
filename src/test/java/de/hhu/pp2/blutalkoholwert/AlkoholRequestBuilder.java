package de.hhu.pp2.blutalkoholwert;

import jakarta.servlet.ServletContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class AlkoholRequestBuilder {

    private Geschlecht geschlecht;
    private double gewicht;
    private double bier;
    private double wein;
    private double korn;
    private double vodka;
    private double whiskey;

    public AlkoholRequestBuilder geschlecht(Geschlecht geschlecht){
        this.geschlecht=geschlecht;
        return this;
    }
    public AlkoholRequestBuilder gewicht(double gewicht){
        this.gewicht=gewicht;
        return this;
    }

    public AlkoholRequestBuilder bier(double bier){
        this.bier=bier;
        return this;
    }

    public AlkoholRequestBuilder wein(double wein){
        this.wein=wein;
        return this;
    }

    public AlkoholRequestBuilder vodka(double vodka){
        this.vodka=vodka;
        return this;
    }

    public AlkoholRequestBuilder korn(double korn){
        this.korn=korn;
        return this;
    }

    public AlkoholRequestBuilder whiskey(double whiskey){
        this.whiskey=whiskey;
        return this;
    }

    public RequestBuilder build(){
       return post("/")
               .param("geschlecht" ,geschlecht.toString())
               .param("gewicht",String.valueOf(gewicht))
               .param("bier" , String.valueOf(bier))
               .param("wein", String.valueOf(wein))
               .param("korn" , String.valueOf(korn))
               .param("vodka", String.valueOf(vodka))
               .param("whiskey", String.valueOf(whiskey));


    }


}
