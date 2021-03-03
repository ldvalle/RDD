package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codigo_retorno",
        "descripcion_retorno",
        "transaccion_pago_enel",
        "fecha_pago_aplicado",
        "hora_pago_aplicado"
})

public class RddNotiResponse extends ResponseBase{ 
    @JsonProperty("transaccion_pago_enel")
    @JsonPropertyDescription("Trx_SC4I (12): Identificador de pago en Sistema comercial Enel Distribuci\u00f3n")
    @Size(max = 20)
    @NotNull
    private String transaccion_pago_enel;

    @JsonProperty("fecha_pago_aplicado")
    @JsonPropertyDescription("FechaPago: Fecha de Pago en formato dd/mm/aaaa")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Argentina/Buenos_Aires")
    @NotNull
    private String fecha_pago_aplicado;

    @JsonProperty("hora_pago_aplicado")
    @JsonPropertyDescription("HoraPago: Hora Pago en formato HH24:MI:SS")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    @NotNull
    private String hora_pago_aplicado;

    public String getTransaccion_pago_enel() {
        return transaccion_pago_enel;
    }
    public void setTransaccion_pago_enel(String transaccion_pago_enel) {
        this.transaccion_pago_enel = transaccion_pago_enel;
    }

    public String getFecha_pago_aplicado() {
        return fecha_pago_aplicado;
    }
    public void setFecha_pago_aplicado(String fecha_pago_aplicado) {
        this.fecha_pago_aplicado = fecha_pago_aplicado;
    }

    public String getHora_pago_aplicado() {
        return hora_pago_aplicado;
    }
    public void setHora_pago_aplicado(String hora_pago_aplicado) {
        this.hora_pago_aplicado = hora_pago_aplicado;
    }

	@Override
	public String toString() {
	  final StringBuilder sb = new StringBuilder("RddNotiResponse{");
	  sb.append(", 'transaccion_pago_enel'='").append(transaccion_pago_enel).append('\'');;
	  sb.append(", 'fecha_pago_aplicado'='").append(fecha_pago_aplicado).append('\'');
	  sb.append(", 'hora_pago_aplicado'='").append(hora_pago_aplicado).append('\'');
	  sb.append('}');
	  return sb.toString();
	}
}

