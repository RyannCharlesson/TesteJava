package com.example.demo.controller;

import com.example.demo.service.AnagramaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
//forma padrão de construção de API REST
@RestController
@RequestMapping("/anagrama")
public class VeirificaAnagramaController {

	
	//AnagramaService anagramaService = new AnagramaService();
	@Autowired
	private AnagramaService anagramaService;
	
	/**
	 * escrever no navegador: localhost:8081/anagrama/verificaAnagrama/{palavra1}/{palavra2}
	 * @param palavra1 recebe a primeira palavra para comparação com a segunda
	 * @param palavra2 recebe a segunda palavra para comparação com a primeira
	 * @return
	 */
    @GetMapping("/verificaAnagrama/{palavra1}/{palavra2}")
    public ResponseEntity<Boolean> verificaAnagrama(@PathVariable("palavra1") String palavra1, @PathVariable("palavra2") String palavra2){
/**
 * vai retornar 'true' se as palavras forem anagramas, caso contrário, retorna 'false'
 */
       var retorno = anagramaService.verificaAnagrama(palavra1, palavra2);

        return ResponseEntity.ok(retorno);

    }


}
