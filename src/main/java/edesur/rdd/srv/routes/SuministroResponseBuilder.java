package edesur.rdd.srv.routes;

import edesur.rdd.srv.model.SuministroResponse;
import edesur.rdd.srv.model.SuministroResultado;
import org.apache.camel.Body;

public class SuministroResponseBuilder {
    public SuministroResponse build(@Body SuministroResultado resultado) {
        SuministroResponse response = new SuministroResponse();
        response.getListaResultado().add(resultado);
        return response;
    }
}
