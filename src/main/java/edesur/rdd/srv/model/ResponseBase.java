package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBase {
    @Size(max = 10)
    @NotNull
    private String codigo_retorno = "0";

    @Size(max = 100)
    @NotNull
    private String descripcion_retorno = "Proceso Exitoso";

    public String getCodigoRetorno() {
        return codigo_retorno;
    }

    public void setCodigoRetorno(String codigo_retorno) {
        this.codigo_retorno = codigo_retorno;
    }

    public String getDescripcionRetorno() {
        return descripcion_retorno;
    }

    public void setDescripcionRetorno(String descripcion_retorno) {
        this.descripcion_retorno = descripcion_retorno;
    }
}
