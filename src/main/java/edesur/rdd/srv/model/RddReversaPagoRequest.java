package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.NotBlank;
import edesur.rdd.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_empresa",
        "cod_recaudador",
        "cod_barra",
        "monto_deuda",
        "transaccion_pago_enel"
})

public class RddReversaPagoRequest {
	@NotNull
	private Integer id_empresa;
	
    @Size(max = 20)
    @NotBlank
    private String cod_recaudador;

    @Size(max = 100)
    @NotBlank
    private String cod_barra;

    @NotNull
    @DecimalMax("9999999999")
    private BigDecimal monto_deuda;

    @NotNull
    private String transaccion_pago_enel;

    // Setters & Getters
    public Integer getId_empresa(){
		return id_empresa;
    }
    public void setId_empresa(Integer id_empresa ){ this.id_empresa = id_empresa; }
    
    public String getCod_recaudador() {
        return cod_recaudador;
    }
    public void setCod_recaudador(String cod_recaudador) {
        this.cod_recaudador = cod_recaudador;
    }

    public String getCod_barra() {
        return cod_barra;
    }
    public void setCodigo_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

	public BigDecimal getMonto_deuda(){
		return monto_deuda;
	}
    public void setMonto_deuda(BigDecimal monto_deuda){
		this.monto_deuda = monto_deuda;
    }
    
    public String getTransaccion_pago_enel() {
        return transaccion_pago_enel;
    }
    public void setTransaccion_pago_enel(String transaccion_pago_enel) {
        this.transaccion_pago_enel = transaccion_pago_enel;
    }

}
