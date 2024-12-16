package com.salesianostriana.dam.resteval;

public record PlaceDTO(
        Long id,
        String name,
        String coords,
        String image
) {

    public PlaceDTO toDTO (Place place){

        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getCoords(),
                place.getImage()
        );
    }

}
