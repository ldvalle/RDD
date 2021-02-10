package edesur.rdd.srv.routes;

import edesur.rdd.srv.errores.ErrorResponse;
import edesur.rdd.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class RddNotiRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setRddNoti")
            .routeId("setRddNoti")
            .setHeader("codigoEmpresa", simple("${body.getCodigoEmpresa}"))
            .setHeader("numeroCliente", simple("${body.getNumeroCliente}"))
            .setHeader("barraFactura", simple("${body.getBarraFactura}"))
            .setHeader("tipoPago", simple("${body.getTipoPago}"))
            .setHeader("montoPago", simple("${body.getMontoPago}"))
            .setHeader("fechaPago", simple("${body.getFechaPago}"))
            .setHeader("codOficina", simple("${body.getCodOficina}"))
            .setHeader("codSucursal", simple("${body.getCodSucursal}"))
            .setHeader("codCajero", simple("${body.getCodCajero}"))
            .log(LoggingLevel.DEBUG, logname, "Registra Pago Cliente ${header.numeroCliente} Barra ${header.barraFactura}")
            .setHeader("response", body())
            .transacted()
            .to("sql:classpath:sql/rddNotiPago.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddNotiResponse")
            .choice()
                .when(body().isNull())
                    .log(LoggingLevel.DEBUG, logname, "Pago no imputado")
                    //.setBody(constant(ErrorResponse.create(ErrorType.PagoNoImputado)))
                .otherwise()
                    .log(LoggingLevel.DEBUG, logname, "Pago Imputado")
            .end();            
             
/*             
			 .transacted()
          .log(LoggingLevel.DEBUG, logname, "Actualiza Datos Comerciales Cliente ${header.numeroCliente}")
          .setHeader("response", body())
			 .to("sql:classpath:sql/spInsMiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ActuDataComerResponse")
			 .choice()
			 .when(body().isNull())
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
				  .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
			 .otherwise()
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
			 .end();                
*/
    }
}
