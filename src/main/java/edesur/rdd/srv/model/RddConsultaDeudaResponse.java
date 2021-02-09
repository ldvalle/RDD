package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import edesur.rdd.srv.model.RddConsultaDeudaResultado;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RddConsultaDeudaResponse extends ResponseBase{ 

	private List<RddConsultaDeudaResultado> listaResultado = new ArrayList<>();

	public List<RddConsultaDeudaResultado> getListaResultado() {
	  return listaResultado;
	}
	public void setListaResultado(List<RddConsultaDeudaResultado> listaResultado) {
	  this.listaResultado = listaResultado;
	}

}
