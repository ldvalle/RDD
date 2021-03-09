package edesur.rdd.srv.routes;

import edesur.rdd.srv.errores.ErrorResponse;
import edesur.rdd.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;
import edesur.rdd.srv.model.RddReversaPagoResponse;


public class RddReversaRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setRddReversa")
            .routeId("setRddReversa")
            
            .setHeader("id_empresa", simple("${body.getId_empresa}"))
            .setHeader("cod_recaudador", simple("${body.getCod_recaudador}"))
            .setHeader("cod_barra", simple("${body.getCod_barra}"))
            .setHeader("monto_deuda", simple("${body.getMonto_deuda}"))
            .setHeader("transaccion_pago_enel", simple("${body.getTransaccion_pago_enel}"))
                        
            .log(LoggingLevel.DEBUG, logname, "Registra Reversa Pago Cliente/Barra ${header.cod_barra}")
            .setHeader("response", body())
            .transacted()
            .to("sql:classpath:sql/rddReversaPago.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddReversaPagoResponse")
            .log(LoggingLevel.DEBUG, logname, "Pago Reversado");

    }
}
