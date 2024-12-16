package com.salesianostriana.dam.resteval.controllers;

import com.salesianostriana.dam.resteval.Place;
import com.salesianostriana.dam.resteval.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/place/")
    public ResponseEntity<List<Place>> getAllPlaces() {
        Optional<List<Place>> listplaceResult = Optional.ofNullable(placeRepository.getAll());

        if (listplaceResult.isPresent()) {

            //Incluir aquí el PlaceListDTO.

            return ResponseEntity.ok(listplaceResult.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Place> getPlaceById (Long id) {
        Optional<Place> placeResult = placeRepository.get(id);

        if (placeResult.isPresent()) {
            return ResponseEntity.ok(placeResult.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/place/")
    public ResponseEntity<Place> addPlace (Place place) {
        Place placeResult = placeRepository.add(place);

        return ResponseEntity.status(HttpStatus.CREATED).body(placeResult);
    }

    @PutMapping("/place/{id}")
    public ResponseEntity<Place> updatePlace (Place place) {
        Optional<Place> placeResult = placeRepository.edit(place.getId(), place);

        if(placeResult.isPresent()) {
            return ResponseEntity.ok(placeResult.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<Place> delete (Long id){
        placeRepository.delete(id);
        return ResponseEntity.ok().build();
    }

}
