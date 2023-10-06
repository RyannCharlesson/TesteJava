package com.example.demo.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnagramaServiceTests {

    @Autowired
    private AnagramaService anagramaService;


    @Test
    void retornaTrueAposVerificarAnagrama(){
        String palavra1 = "Ryann";
        String palavra2 = "annry";
        
        boolean retorno = anagramaService.verificaAnagrama(palavra1, palavra2);

        assertTrue(retorno);
    }

    @Test
    void retornaFalseAposVerificarAnagrama(){
        String palavra1 = "Ryunn";
        String palavra2 = "annry";

        boolean retorno = anagramaService.verificaAnagrama(palavra1, palavra2);

        assertFalse(retorno);
    }

    @Test
    void retornaFalseAposParametrosNulos(){

        boolean retorno = anagramaService.verificaAnagrama(null, null);

        assertFalse(retorno);
    }


}
