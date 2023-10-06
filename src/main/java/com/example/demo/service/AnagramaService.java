package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AnagramaService {

    public boolean verificaAnagrama(String palavra1, String palavra2) {

        // verificando se algum parametro é nulo.
    	if(palavra1 == null || palavra2 == null){
            return false;
        }
    	
        // verificando se as duas palavras tem o mesmo tamanho. 
        if(palavra2.length() != palavra1.length()){
        	return false;
        }
        
        //transformando em array e letras maiusculas para evitar bug.
        char[] arrayPalavra1 = palavra1.toUpperCase().toCharArray();
        char[] arrayPalavra2 = palavra2.toUpperCase().toCharArray();
        
        //criação do map para armazenar a primeira palavra.
        HashMap<Character, Integer> quantidadeFrequencia = new HashMap<>();

        //iterando no array e armazenando no map.
        for(char arrayLetras: arrayPalavra1) {
            quantidadeFrequencia.put(arrayLetras, quantidadeFrequencia.getOrDefault(arrayLetras, 0)+1);
        }
        //iterando a segunda palavra e comparando com a primeira já armazenada.
        for(char arrayLetras: arrayPalavra2){
            if(!quantidadeFrequencia.containsKey(arrayLetras)) {
                return false;
            }
            
            //comparando a existencia de letras repetidas e removendo do map.
            quantidadeFrequencia.put(arrayLetras, quantidadeFrequencia.get(arrayLetras) - 1);
            
            //limpando o map após validação.
            if (quantidadeFrequencia.get(arrayLetras) == 0) {
            	quantidadeFrequencia.remove(arrayLetras);
            }

        }
        //certificando que o map ficou vazio: true || false 
        return quantidadeFrequencia.isEmpty();
        
    }
    
}
