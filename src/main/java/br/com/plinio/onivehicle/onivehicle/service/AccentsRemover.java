package br.com.plinio.onivehicle.onivehicle.service;

import java.text.Normalizer;

public class AccentsRemover {
    public String RemoveAccents(String input){
        String nomalizedText = Normalizer
                .normalize(input, Normalizer.Form.NFKD)
                .replaceAll("\\p{M}", "");

        return nomalizedText;
    }
}
