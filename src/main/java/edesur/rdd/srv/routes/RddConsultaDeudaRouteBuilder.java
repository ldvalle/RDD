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
            
            .setHeader("codigoEmpresa", simple("${body.getId_empresa}"))
            .setHeader("tipoBusqueda", simple("${body.getTipo_busqueda}"))
            .setHeader("valorBusqueda", simple("${body.getValor_busqueda}"))
            .setHeader("codigoRecaudador", simple("${body.getCod_recaudador}"))
            .setHeader("credencialRecau", simple("${body.getCred_recaudador}"))
            .setHeader("codOficinaRecau", simple("${body.getCod_oficina_recaudador}"))
            .setHeader("codCajaRecau", simple("${body.getCod_caja_recaudador}"))
            .log(LoggingLevel.DEBUG, logname, "Consulta deuda Cliente o Barra ${header.valorBusqueda}")
            .setHeader("response", body())
            //.transacted()
            .to("sql:classpath:sql/rdd_valida_deuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResponse")
            //.enrich("sql:classpath:sql/rddConsultaDeuda.sql?dataSource=#SynergiaDS&outputType=SelectList&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResultado", listaResultado )
            //.log(LoggingLevel.DEBUG, logname, "Deuda Informada");
            //.setHeader("codRetorno", simple("${body.getCodigo_retorno}"))
            //.setBody(simple("${response.getCodigo_retorno}"))

            .choice()
				//.when(header("codRetorno").isEqualTo("0"))
				//.when(body().contains("OK"))
				.when().simple("${body.codigo_retorno} == '000'")
					.enrich("sql:classpath:sql/rddConsultaDeuda.sql?dataSource=#SynergiaDS&outputType=SelectList&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResultado", listaResultado )
					.log(LoggingLevel.DEBUG, logname, "Deuda Informada")
			.end();

            //.to("sql:classpath:sql/rddConsultaDeuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResponse")
            //.log(LoggingLevel.DEBUG, logname, "Deuda Informada");
/*            
            .to("sql:classpath:sql/rddExisteDeuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResponse")
            .choice()
                //.when(body().isNull())
                .when(body().contains("Cliente/Barra no existe"))
                    .log(LoggingLevel.DEBUG, logname, "Deuda No Existe")
                    //.setBody(constant(ErrorResponse.create(ErrorType.DeudaNoExiste)))
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
                .otherwise()
					.enrich("sql:classpath:sql/rddConsultaDeuda.sql?dataSource=#SynergiaDS&outputType=SelectList&outputClass=edesur.rdd.srv.model.RddConsultaDeudaResultado", listaResultado )
                    .log(LoggingLevel.DEBUG, logname, "Deuda Informada")
            .end();            
*/             
    }
}
