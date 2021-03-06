package edesur.rdd.srv.routes;

import edesur.rdd.srv.errores.ErrorResponse;
import edesur.rdd.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class DirSumRouteBuilder extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:getDirSum")
                .routeId("getDirSum")
                .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
                .log(LoggingLevel.DEBUG, logname, "Consulta Direccion Suministro ${header.numeroCliente}")
                .to("sql:classpath:sql/dirSum.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.DirSumResponse")
                .choice()
                .when(body().isNull())
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
                .otherwise()
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();
    }
}
