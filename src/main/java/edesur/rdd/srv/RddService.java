package edesur.rdd.srv;

import edesur.rdd.srv.model.RddConsultaDeudaRequest;
import edesur.rdd.srv.model.RddConsultaDeudaResponse;

/*
import edesur.rdd.srv.model.ActuDataComerRequest;
import edesur.rdd.srv.model.ActuDataComerResponse;

import edesur.rdd.srv.model.ConsultaCorteRepoRequest;
import edesur.rdd.srv.model.ConsultaCorteRepoResponse;
*/

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RddService {
/*	
    @POST
    @Path("/actuDataComer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActuDataComerResponse actuDataComer(@NotNull @Valid ActuDataComerRequest request) {
        return null;
    }

    @POST
    @Path("/consultaCorteRepo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ConsultaCorteRepoResponse consultaCorteRepo(@NotNull @Valid ConsultaCorteRepoRequest request) {
        return null;
    }    
*/

    @POST
    @Path("/consultaDeuda")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RddConsultaDeudaResponse consultaDeuda(@NotNull @Valid RddConsultaDeudaRequest request) {
        return null;
    }	

}
