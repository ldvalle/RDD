package edesur.rdd.srv.routes;

import edesur.rdd.srv.errores.ErrorResponse;
import edesur.rdd.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

import edesur.rdd.srv.model.RddConsultaDeudaResponse;
import edesur.rdd.srv.model.RddConsultaDeudaResultado;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import edesur.rdd.srv.beans.BeanPropertyAggregationStrategy;

public class RddConsultaDeudaRouteBuilder extends  BaseRouteBuilder {
	
	private final AggregationStrategy listaResultado = new BeanPropertyAggregationStrategy<RddConsultaDeudaResultado>("listaResultado");	
	
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setRddConsulta")
            .routeId("setRddConsulta")
            
            .setHeader("codigoEmpresa", simple("${body.getIdEmpresa}"))
            .setHeader("tipoBusqueda", simple("${body.getTipoBusqueda}"))
            .setHeader("valorBusqueda", simple("${body.getValorBusqueda}"))
            .setHeader("codigoRecaudador", simple("${body.getCodRecaudador}"))
            .setHeader("credencialRecau", simple("${body.getCredRecaudador}"))
            .setHeader("codOficinaRecau", simple("${body.getCodOficinaRecaudador}"))
            .setHeader("codCajaRecau", simple("${body.getCodCajaRecaudador}"))
            .setHeader("codSucursal", simple("${body.getCodSucursal}"))
            .setHeader("codCajero", simple("${body.getCodCajero}"))

			.to("class:edesur.rdd.srv.model.RddConsultaDeudaRequest?method=setValoresBarra")
			
            .setHeader("barCodEmpresa", simple("${body.getBarEmpresa}"))
            
            .log(LoggingLevel.DEBUG, logname, "Consulta deuda Cliente o Barra ${header.valorBusqueda}")
            .setHeader("response", body())
            //.transacted()
            .to("sql:classpath:sql/rddExisteDeuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResponse")
            .choice()
                .when(body().isNull())
                    .log(LoggingLevel.DEBUG, logname, "Deuda No Existe")
                    //.setBody(constant(ErrorResponse.create(ErrorType.PagoNoImputado)))
                .otherwise()
					.enrich("sql:classpath:sql/rddConsultaDeuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResultado", listaResultado )
                    .log(LoggingLevel.DEBUG, logname, "Deuda Informada")
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
