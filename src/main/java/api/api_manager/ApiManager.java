package api.api_manager;

import api.modeles.google_places.GooglePlacesModel;
import lombok.Getter;
import lombok.Setter;

public class ApiManager {

    @Getter
    @Setter
    GooglePlacesModel googlePlacesModel = new GooglePlacesModel();
}
