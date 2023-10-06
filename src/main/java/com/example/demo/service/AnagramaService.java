package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AnagramaService {

    public boolean verificaAnagrama(String palavra1, String palavra2) {

        if(palavra1 == null || palavra2 == null){
            return false;
        }

        var arrPalavra1 = palavra1.toCharArray();
        var quantidadeFrequencia = new HashMap<Character, Integer>();

        if(palavra2.length() != palavra1.length()){
            return false;
        }

        for(char c : arrPalavra1) {
            quantidadeFrequencia.put(c, quantidadeFrequencia.getOrDefault(c, 0)+1);
        }

        for(char c: palavra2.toCharArray()){
            if(!quantidadeFrequencia.containsKey(c)) {
                return false;
            }

        }

        return true;
    }


}
