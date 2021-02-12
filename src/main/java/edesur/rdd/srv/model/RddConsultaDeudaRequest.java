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


public class RddConsultaDeudaRequest {
    @Size(max = 1)
    private String id_empresa;

    @Size(max = 25)
    private String tipo_busqueda;

    @Size(max = 100)
    private String valor_busqueda;

    @Size(max = 20)
    private String cod_recaudador;

    @Size(max = 200)
    private String cred_recaudador;

    @Size(max = 4)
    private String cod_oficina_recaudador;

    @Size(max = 20)
	private String cod_caja_recaudador;


	//-- Datos de la Barra
/*	
	private String barEmpresa;
	private String barSucursal;
	private String barPlan;
	private String barCliente;
	private String barImporte;
	private String barVcto1;
	private String barRecargo;
	private String barVcto2;
	private String barCorrFactu;
	private String barTipoBarra;
	private String barDV;
*/	

	//Setters & Getters
    public String getId_empresa() { return id_empresa; }
    public void setId_empresa(String id_empresa) { this.id_empresa = id_empresa; }

    public String getTipo_busqueda() { return tipo_busqueda; }
    public void setTipo_busqueda(String tipo_busqueda) { this.tipo_busqueda = tipo_busqueda; }

	public String getValor_busqueda(){ return valor_busqueda; }
	public void setValor_busqueda(String valor_busqueda) { this.valor_busqueda = valor_busqueda; }
	
	public String getCod_recaudador(){ return cod_recaudador; }
	public void setCod_recaudador(String cod_recaudador) { this.cod_recaudador = cod_recaudador; }
	
	public String getCred_recaudador(){ return cred_recaudador; }
	public void setCred_recaudador(String cred_recaudador) { this.cred_recaudador = cred_recaudador; }
	
	public String getCod_oficina_recaudador(){ return cod_oficina_recaudador; }
	public void setCod_oficina_recaudador(String cod_oficina_recaudador) { this.cod_oficina_recaudador = cod_oficina_recaudador; }

	public String getCod_caja_recaudador(){ return cod_caja_recaudador; }
	public void setCod_caja_recaudador(String cod_caja_recaudador) { this.cod_caja_recaudador = cod_caja_recaudador; }

	//0095341010025350000126772102230015220228012062
/*
	public String getNroCliente(){ return valor_busqueda; }	
	
	public void setValoresBarra() {
		if(tipo_busqueda.equals("cod_barra")){
			barEmpresa=valor_busqueda.substring(0, 3);
			barSucursal = valor_busqueda.substring(3, 5);
			barPlan = valor_busqueda.substring(5, 7);
			barCliente = valor_busqueda.substring(7, 15);
			barImporte = valor_busqueda.substring(15, 24);
			barVcto1 = valor_busqueda.substring(24, 30);
			barRecargo = valor_busqueda.substring(30, 36);
			barVcto2 = valor_busqueda.substring(36, 40);
			barCorrFactu = valor_busqueda.substring(40, 43);
			barTipoBarra= valor_busqueda.substring(43, 45);
			String barDV= valor_busqueda.substring(45, 46);
		}
	}

	public String getBarEmpresa(){ return barEmpresa; }
	public String getBarSucursal(){ return barSucursal; }
	public String getBarPlan(){ return barPlan; }
	public String getBarCliente(){ return barCliente; }
	public String getBarImporte(){ return barImporte; }
	public String getBarVcto1(){ return barVcto1; }
	public String getBarRecargo(){ return barRecargo; }
	public String getBarVcto2(){ return barVcto2; }
	public String getBarCorrFactu(){ return barCorrFactu; }
	public String getBarTipoBarra(){ return barTipoBarra; }
	public String getBarDV(){ return barDV; }
	
*/	
	
}
