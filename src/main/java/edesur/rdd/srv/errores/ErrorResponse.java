package edesur.rdd.srv.errores;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edesur.rdd.srv.model.ResponseBase;
import org.apache.camel.component.bean.validator.BeanValidationException;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public final class ErrorResponse extends ResponseBase {
    @JsonIgnore
    private Response.Status statusCode;

    public static ErrorResponse create(ErrorType type) {
        return new ErrorResponse(type.getCodigoRetorno(), type.getDescripcionRetorno());
    }

    public static ErrorResponse create(ErrorType type, String descripcion_retorno) {
        return new ErrorResponse(type.getCodigoRetorno(), descripcion_retorno);
    }

    public static ErrorResponse createFromException(Exception e) {
        ErrorResponse errorResponse;
        if (e instanceof SQLException) {
            errorResponse = create(ErrorType.SqlError);
            errorResponse.statusCode = Response.Status.INTERNAL_SERVER_ERROR;
            errorResponse.setDescripcionRetorno(e.getMessage());
        }
        if (e instanceof BeanValidationException) {
            errorResponse = new ErrorResponse((BeanValidationException)e);
        }
        else {
            errorResponse = create(ErrorType.InternalError);
            errorResponse.statusCode = Response.Status.INTERNAL_SERVER_ERROR;
            errorResponse.setDescripcionRetorno(e.getMessage());
        }
        return errorResponse;
    }

    private ErrorResponse(String codigo, String descripcion_retorno) {
        super.setCodigoRetorno((codigo_retorno));
        super.setDescripcionRetorno((descripcion_retorno));
    }

    private ErrorResponse(BeanValidationException e) {
        super.setCodigo(ErrorType.ParametersValidationError.getCodigo());
        String m = e.getMessage().replaceAll("(?s)^(.*)( for: .*)(errors: \\[.*\\])(.*)$", "$1, $3");
        super.setDescripcionRetorno(m);
        statusCode = Response.Status.BAD_REQUEST;
    }

    public int getStatusCode() {
        return statusCode.getStatusCode();
    }
}
