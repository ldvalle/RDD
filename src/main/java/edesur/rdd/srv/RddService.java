package edesur.rdd.srv;

import edesur.rdd.srv.model.RddConsultaDeudaRequest;
import edesur.rdd.srv.model.RddConsultaDeudaResponse;

import edesur.rdd.srv.model.RddNotiRequest;
import edesur.rdd.srv.model.RddNotiResponse;

import edesur.rdd.srv.model.RddReversaPagoRequest;
import edesur.rdd.srv.model.RddReversaPagoResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RddService {
    @POST
    @Path("/notificaPago")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RddNotiResponse notificaPago(@NotNull @Valid RddNotiRequest request) {
        return null;
    }    

    @POST
    @Path("/consultaDeuda")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RddConsultaDeudaResponse consultaDeuda(@NotNull @Valid RddConsultaDeudaRequest request) {
        return null;
    }	

    @POST
    @Path("/reversaPago")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RddReversaPagoResponse reversaPago(@NotNull @Valid RddReversaPagoRequest request) {
        return null;
    }	
    
}
