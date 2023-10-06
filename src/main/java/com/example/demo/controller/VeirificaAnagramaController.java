package com.example.demo.controller;

import com.example.demo.service.AnagramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagrama")
public class VeirificaAnagramaController {

    @Autowired
    private AnagramaService anagramaService;

    @GetMapping("/verificaAnagrama/{palavra1}/{palavra2}")
    public ResponseEntity<Boolean> verificaAnagrama(@PathVariable("palavra1") String palavra1, @PathVariable("palavra2") String palavra2){

       var retorno = anagramaService.verificaAnagrama(palavra1, palavra2);

        return ResponseEntity.ok(retorno);

    }


}
