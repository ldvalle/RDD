package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.rdd.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;


@JsonInclude(JsonInclude.Include.NON_NULL)


public class RddNotiRequest {
    @Size(max = 4)
    private String codigoEmpresa;

    @Size(max = 12)
    private String numeroCliente;

    @Size(max = 46)
    private String barraFactura;

    @Size(max = 10)
    private String tipoPago;

    @DecimalMax("9999999999")
    private BigDecimal montoPago;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
	private Date fechaPago;

    @Size(max = 4)
    private String codOficina;

    @Size(max = 10)
    private String codSucursal;

    @Size(max = 20)
	private String codCajero;

	//Setters & Getters
    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }
    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }
    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

	public String getBarraFactura(){ return barraFactura; }
	public void setBarraFactura(String barraFactura) { this.barraFactura = barraFactura; }
	
	public String getTipoPago(){ return tipoPago; }
	public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
	
	public BigDecimal getMontoPago(){ return montoPago; }
	public void setMontoPago(BigDecimal montoPago) { this.montoPago = montoPago; }
	
	public Date getFechaPago(){ return fechaPago; }
	public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }
	
	public String getCodOficina(){ return codOficina; }
	public void setCodOficina(String codOficina) { this.codOficina = codOficina; }

	public String getCodSucursal(){ return codSucursal; }
	public void setCodSucursal(String codSucursal) { this.codSucursal = codSucursal; }

	public String getCodCajero(){ return codCajero; }
	public void setCodCajero(String codCajero) { this.codCajero = codCajero; }	

}
