package edesur.rdd.srv.routes;

import edesur.rdd.srv.errores.ErrorResponse;
import edesur.rdd.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;
import edesur.rdd.srv.model.RddNotiResponse;


public class RddNotiRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setRddNoti")
            .routeId("setRddNoti")
            
            .setHeader("id_empresa", simple("${body.getId_empresa}"))
            .setHeader("cod_recaudador", simple("${body.getCod_recaudador}"))
            .setHeader("cod_oficina_recaudador", simple("${body.getCod_oficina_recaudador}"))
            .setHeader("cod_caja_recaudador", simple("${body.getCod_caja_recaudador}"))
            .setHeader("cod_barra", simple("${body.getCod_barra}"))
            .setHeader("numero_comprobante", simple("${body.getNumero_comprobante}"))
            .setHeader("fecha_rendicion", simple("${body.getFecha_rendicion}"))
            .setHeader("fecha_pago_recaudador", simple("${body.getFecha_pago_recaudador}"))
            .setHeader("hora_pago_recaudador", simple("${body.getHora_pago_recaudador}"))
            .setHeader("sesion_bco", simple("${body.getSesion_bco}"))
            .setHeader("cod_medio_pago", simple("${body.getCod_medio_pago}"))
            .setHeader("info_medio_pago1", simple("${body.getInfo_medio_pago1}"))
            .setHeader("info_medio_pago2", simple("${body.getInfo_medio_pago2}"))
            .setHeader("info_medio_pago3", simple("${body.getInfo_medio_pago3}"))
            .setHeader("info_medio_pago4", simple("${body.getInfo_medio_pago4}"))
            .setHeader("info_medio_pago5", simple("${body.getInfo_medio_pago5}"))
                        
            .log(LoggingLevel.DEBUG, logname, "Registra Pago Cliente/Barra ${header.cod_barra}")
            .setHeader("response", body())
            .transacted()
            .to("sql:classpath:sql/rddNotiPago.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddNotiResponse")
            .log(LoggingLevel.DEBUG, logname, "Pago Imputado");

    }
}
