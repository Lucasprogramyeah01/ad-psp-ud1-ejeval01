package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {

        //Place 1: Bar Los Meri.
        Place p1 = new Place(
                1L,
                "Bar Los Meri",
                "Calle López de Legazpi",
                "1N 2S",
                "Tus tapas favoritas están aquí.",
                Arrays.asList("Bueno", "Bonito", "Barato"),
                "HE AQUÍ LA IMAGEN."
        );

        //Place 2: Bar Los Meri.
        Place p2 = new Place(
                2L,
                "Restaurante Arousa",
                "Calle Galicia",
                "3N 4S",
                "Galleguinho.",
                Arrays.asList("Limpio", "Amplio"),
                "HE AQUÍ LA IMAGEN."
        );
    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }

}
