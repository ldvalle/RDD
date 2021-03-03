package edesur.rdd.srv.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class AppRouteBuilder extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer")
                .routeId("restEndpointConsumer")
                .choice()
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("consultaDeuda"))
                        .to("direct:setRddConsulta")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("notificaPago"))
                        .to("direct:setRddNoti")
                        
                    .otherwise()
                        .log(LoggingLevel.ERROR, "Operacion no implementada: " + header(CxfConstants.OPERATION_NAME))
                .end();
    }
}
