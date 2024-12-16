package com.salesianostriana.dam.resteval;

import java.util.List;

public record PlaceListDTO(
        int count,
        List<PlaceDTO> listPlaces
) {

    public PlaceListDTO toDTO (List<PlaceDTO> list) {
        return new PlaceListDTO(list.size(), list);
    }

}
