package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "codigo_retorno",
    "descripcion_retorno",
	"cod_barra",
	"tipo_deuda",
	"monto_deuda",
	"tipo_documento",
	"numero_documento",
	"fecha_emision",
	"fecha_vencimiento",
	"nombre_cliente",
	"estado_cliente",
	"direccion",
	"mensaje",
	"publicidad"
})

public class RddConsultaDeudaResponse extends ResponseBase{ 
    @NotNull
	private String cod_barra;
	@NotNull
	private String tipo_deuda;
	@NotNull
	private BigDecimal monto_deuda=BigDecimal.ZERO;
	@NotNull
	private String tipo_documento;
	@NotNull
	private String	numero_documento;
	@NotNull
	private String fecha_emision;
	@NotNull
	private String fecha_vencimiento;
	@NotNull
	private String nombre_cliente;
	@NotNull
	private String estado_cliente;
	@NotNull
	private String direccion;
	
	private String mensaje;	
	private String publicidad;
	
	/* Getters & Setters  */
	public String getCod_barra() { return cod_barra;	}
	public void setCod_barra(String cod_barra) { this.cod_barra = cod_barra; }	
	
	public void setTipo_deuda(String tipo_deuda){ this.tipo_deuda = tipo_deuda; }
	public String getTipo_deuda(){ return tipo_deuda; }
	
	public void setMonto_deuda(BigDecimal monto_deuda){ this.monto_deuda = monto_deuda; }
	public BigDecimal getMonto_deuda(){ return monto_deuda; }

    private BigDecimal round(BigDecimal value) {
        return value == null ? null : value.setScale(2, RoundingMode.HALF_EVEN);
    }
	
	public void setTipo_documento(String tipo_documento){ this.tipo_documento = tipo_documento; }
	public String getTipo_documento(){ return tipo_documento; }

	public void setNumero_documento(String numero_documento){ this.numero_documento = numero_documento; }
	public String getNumero_documento(){ return numero_documento; }

	public void setFecha_emision(String fecha_emision){ this.fecha_emision = fecha_emision; }
	public String getFechaEmision(){ return fecha_emision; }
	
	public void setFecha_vencimiento(String fecha_vencimiento){ this.fecha_vencimiento = fecha_vencimiento; }
	public String getFecha_vencimiento(){ return fecha_vencimiento; }	
	
	public void setNombre_cliente(String nombre_cliente){ this.nombre_cliente = nombre_cliente; }
	public String getNombre_cliente(){ return nombre_cliente; }	
	
	public void setEstado_cliente(String estado_cliente){ this.estado_cliente = estado_cliente; }
	public String getEstado_cliente(){ return estado_cliente; }

	public void setDireccion(String direccion){ this.direccion = direccion; }
	public String getDireccion(){ return direccion; }
	
	public void setMensaje(String mensaje){ this.mensaje = mensaje; }
	public String getMensaje(){ return mensaje; }	
	
	public void setPublicidad(String publicidad){ this.publicidad = publicidad; }
	public String getPublicidad(){ return publicidad; }		
	
	@Override
	public String toString() {
	  final StringBuilder sb = new StringBuilder("RddConsultaDeudaResultado{");
	  sb.append(", 'cod_barra'=").append(cod_barra);
	  sb.append(", 'tipo_deuda'='").append(tipo_deuda).append('\'');
	  sb.append(", 'monto_deuda'=").append(monto_deuda);
	  sb.append(", 'tipo_documento'='").append(tipo_documento).append('\'');
	  sb.append(", 'numero_documento'='").append(numero_documento).append('\'');
	  sb.append(", 'fecha_emision'='").append(fecha_emision).append('\'');
      sb.append(", 'fecha_vencimiento'='").append(fecha_vencimiento).append('\'');
	  sb.append(", 'nombre_cliente'='").append(nombre_cliente).append('\'');
	  sb.append(", 'estado_cliente'='").append(estado_cliente).append('\'');
	  sb.append(", 'direccion'='").append(direccion).append('\'');
	  sb.append(", 'mensaje'='").append(mensaje).append('\'');
	  sb.append(", 'publicidad'='").append(publicidad).append('\'');
	  sb.append('}');
	  return sb.toString();
	}

}
