package api.modeles.google_places;

import api.utils.NetworkCore;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import static constants.Constants.Endpoint.GOOGLE_PLACE_ENDPOINT_SEARCH;
import static constants.Constants.Path.GOOGLE_PLACE_PATH;
import static constants.Constants.ServerName.GOOGLE_PLACE_SERVER;

public class GooglePlacesModel extends NetworkCore {

    @Setter
    @Getter
    @Builder
    public static class RequestModel{
        private String key;
        private String input;
        private String inputtype;
    }

    public GooglePlacesModel search(RequestModel model, Method method, int statusCode){
        HashMap requestsParams = new HashMap();
        requestsParams.put("key", model.getKey());
        requestsParams.put("input",model.getInput());
        requestsParams.put("inputtype", model.getInputtype());
        requestSpecBuilder.setBaseUri(GOOGLE_PLACE_SERVER + GOOGLE_PLACE_PATH + GOOGLE_PLACE_ENDPOINT_SEARCH)
                .addQueryParams(requestsParams);
        sentRequestAndGetResponse(method, statusCode);
        return this;
    }
}
