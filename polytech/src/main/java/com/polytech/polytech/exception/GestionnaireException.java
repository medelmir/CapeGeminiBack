package com.polytech.polytech.exception;

import com.polytech.polytech.exception.BoiteInexistanteException;
import com.polytech.polytech.exception.CoordonneesInexistantesException;
import com.polytech.polytech.exception.UtilisateurInexistantException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GestionnaireException {
    //cette methode est pour les argument non valid par exemple : email ,nom ,etc : non valid ou vide (depend de ce que tu as utiliser dans RequestDto)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> argumentNonValid(MethodArgumentNotValidException notre_exception) {
        Map<String, String> listerreurs = new HashMap<>();
        notre_exception.getBindingResult().getFieldErrors().forEach(error -> listerreurs.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listerreurs);
    }

    @ExceptionHandler(UtilisateurInexistantException.class)
    public ResponseEntity<Map<String, String>> gererUtilisateurInexistant(UtilisateurInexistantException notre_exception) {
        Map<String, String> listerreurs = new HashMap<>();
        listerreurs.put("id", "Aucun utilisateur avec ce identifiant");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listerreurs);
    }

    @ExceptionHandler(BoiteInexistanteException.class)
    public ResponseEntity<Map<String, String>> gererBoiteInexistant(BoiteInexistanteException notre_exception) {
        Map<String, String> listerreurs = new HashMap<>();
        listerreurs.put("id", "Aucun Boite avec ce identifiant");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listerreurs);
    }

    @ExceptionHandler(CoordonneesInexistantesException.class)
    public ResponseEntity<Map<String, String>> gererCoordonneesInexistant(CoordonneesInexistantesException notre_exception) {
        Map<String, String> listerreurs = new HashMap<>();
        listerreurs.put("id", "Aucun Coordonnees avec ce identifiant");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listerreurs);
    }
}
