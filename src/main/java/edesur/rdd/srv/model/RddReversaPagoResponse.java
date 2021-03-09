package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codigo_retorno",
        "descripcion_retorno"
})

public class RddReversaPagoResponse extends ResponseBase{ }

