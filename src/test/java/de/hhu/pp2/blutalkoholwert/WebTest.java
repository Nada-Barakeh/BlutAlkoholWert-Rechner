package de.hhu.pp2.blutalkoholwert;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(AlkoholController.class)
public class WebTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Startseite unter / vorhanden ist -->(GET)")
    void test1() throws Exception{
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("alkpholForm"));
    }

    @Test
    @DisplayName("Berechnung mit gültigen Werten -->Post")
    void test2() throws Exception{
        mvc.perform(post("/")
                .param("geschlecht" ,"MÄNNER")
                .param("gewicht" , "45")
                .param("bier" , "500")
                .param("wein", "0")
                .param("korn", "0")
                .param("vodka", "0")
                .param("whiskey", "0")
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("blutAlkoholwert"));
    }


    @Test
    @DisplayName("ValidiationsFehler -->Post")
    void test3() throws Exception {
        mvc.perform(post("/")
                .param("geschlecht" ,"FRAUEN")
                .param("gewicht" , "-10") // -ve gewicht
                .param("bier" , "500")
                .param("wein", "0")
                .param("korn", "0")
                .param("vodka", "0")
                .param("whiskey", "0")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("form"))

                .andExpect(model().attributeHasFieldErrors("alkoholForm","gewicht"))
                .andExpect(model().attributeDoesNotExist("blutAlkoholwert"));
    }

}
