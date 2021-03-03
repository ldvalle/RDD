package edesur.rdd.srv.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.NotBlank;
import edesur.rdd.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id_empresa",
        "cod_recaudador",
        "cod_oficina_recaudador",
        "cod_caja_recaudador",
        "cod_barra",
        "numero_comprobante",
        "fecha_rendicion",
        "fecha_pago_recaudador",
        "hora_pago_recaudador",
        "sesion_bco",
        "cod_medio_pago",
        "info_medio_pago1",
        "info_medio_pago2",
        "info_medio_pago3",
        "info_medio_pago4",
        "info_medio_pago5"
})

public class RddNotiRequest {
	@NotNull
	private Integer id_empresa;

    //@JsonProperty("cod_recaudador")
    //@JsonPropertyDescription("C\u00f3digo con que Enel Distribuci\u00f3n identifica al recaudador en sus sistemas")
    @Size(max = 20)
    @NotBlank
    private String cod_recaudador;

    //@JsonProperty("cod_oficina_recaudador")
    //@JsonPropertyDescription("C\u00f3digo con el cual se identifican las oficinas de recaudador")
    @Size(max = 4)
    private String cod_oficina_recaudador;

    //@JsonProperty("cod_caja_recaudador")
    //@JsonPropertyDescription("C\u00f3digo con el cual se identifican las cajas de recaudador")
    @Size(max = 4)
    private String cod_caja_recaudador;

    //@JsonProperty("cod_barra")
    //@JsonPropertyDescription("C\u00f3digo de barras del documento el cual fue entregado en la consulta de deuda")
    @Size(max = 100)
    @NotBlank
    private String cod_barra;

    //@JsonProperty("numero_comprobante")
    //@JsonPropertyDescription("N\u00famero de comprobante asignado por el Recaudador al pago")
    @Size(max = 25)
    @NotBlank
    private String numero_comprobante;

    //@JsonProperty("fecha_rendicion")
    //@JsonPropertyDescription("Fecha en que el recaudador relizar\u00e1 la rendici\u00f3n del pago informado dd/mm/aaaa")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Argentina/Buenos_Aires")
    @NotNull
    private String fecha_rendicion;

    //@JsonProperty("fecha_pago_recaudador")
    //@JsonPropertyDescription("Fecha en que el cliente realiza el pago al recaudador en formato dd/mm/aaaa")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Argentina/Buenos_Aires")
    @NotNull
    private String fecha_pago_recaudador;

    //@JsonProperty("hora_pago_recaudador")
    //@JsonPropertyDescription("Hora en que el cliente realiza el pago al recaudador en formato hh24:mi:ss")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "America/Argentina/Buenos_Aires")
    @NotNull
    private String hora_pago_recaudador;

    //@JsonProperty("sesion_bco")
    //@JsonPropertyDescription("Id identificador de la sesion generada por el banco")
    @Size(max = 25)
    @NotBlank
    private String sesion_bco;

    //@JsonProperty("cod_medio_pago")
    //@JsonPropertyDescription("C\u00f3digo de medio de Pago")
    @Size(max = 250)
    @NotBlank
    private String cod_medio_pago;

    //@JsonProperty("info_medio_pago1")
    //@JsonPropertyDescription("Informaci\u00f3n del medio de pago")
    @Size(max = 250)
    private String info_medio_pago1;

    //@JsonProperty("info_medio_pago2")
    //@JsonPropertyDescription("Informaci\u00f3n del medio de pago")
    @Size(max = 250)
    private String info_medio_pago2;

    //@JsonProperty("info_medio_pago3")
    //@JsonPropertyDescription("Informaci\u00f3n del medio de pago")
    @Size(max = 250)
    private String info_medio_pago3;

    //@JsonProperty("info_medio_pago4")
    //@JsonPropertyDescription("Informaci\u00f3n del medio de pago")
    @Size(max = 250)
    private String info_medio_pago4;

    //@JsonProperty("info_medio_pago5")
    //@JsonPropertyDescription("Informaci\u00f3n del medio de pago")
    @Size(max = 250)
    private String info_medio_pago5;


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

    public String getCod_oficina_recaudador() {
        return cod_oficina_recaudador;
    }
    public void setCod_oficina_recaudador(String cod_oficina_recaudador) {
        this.cod_oficina_recaudador = cod_oficina_recaudador;
    }

    public String getCod_caja_recaudador() {
        return cod_caja_recaudador;
    }
    public void setCod_caja_recaudador(String cod_caja_recaudador) {
        this.cod_caja_recaudador = cod_caja_recaudador;
    }

    public String getCod_barra() {
        return cod_barra;
    }
    public void setCodigo_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getNumero_comprobante() {
        return numero_comprobante;
    }
    public void setNumero_comprobante(String numero_comprobante) {
        this.numero_comprobante = numero_comprobante;
    }

    public String getFecha_rendicion() {
        return fecha_rendicion;
    }
    public void setFecha_rendicion(String fecha_rendicion) {
        this.fecha_rendicion = fecha_rendicion;
    }

    public String getFecha_pago_recaudador() {
        return fecha_pago_recaudador;
    }
    public void setFecha_pago_recaudador(String fecha_pago_recaudador) {
        this.fecha_pago_recaudador = fecha_pago_recaudador;
    }

    public String getHora_pago_recaudador() {
        return hora_pago_recaudador;
    }
    public void setHora_pago_recaudador(String hora_pago_recaudador) {
        this.hora_pago_recaudador = hora_pago_recaudador;
    }

    public String getSesion_bco() {
        return sesion_bco;
    }
    public void setSesion_bco(String sesion_bco) {
        this.sesion_bco = sesion_bco;
    }

    public String getCod_medio_pago() {
        return cod_medio_pago;
    }
    public void setCod_medio_pago(String cod_medio_pago) {
        this.cod_medio_pago = cod_medio_pago;
    }

    public String getInfo_medio_pago1() {
        return info_medio_pago1;
    }
    public void setInfo_medio_pago1(String info_medio_pago1) {
        this.info_medio_pago1 = info_medio_pago1;
    }

    public String getInfo_medio_pago2() {
        return info_medio_pago2;
    }
    public void setInfo_medio_pago2(String info_medio_pago2) {
        this.info_medio_pago2 = info_medio_pago2;
    }

    public String getInfo_medio_pago3() {
        return info_medio_pago3;
    }
    public void setInfo_medio_pago3(String info_medio_pago3) {
        this.info_medio_pago3 = info_medio_pago3;
    }

    public String getInfo_medio_pago4() {
        return info_medio_pago4;
    }
    public void setInfo_medio_pago4(String info_medio_pago4) {
        this.info_medio_pago4 = info_medio_pago4;
    }

    public String getInfo_medio_pago5() {
        return info_medio_pago5;
    }
    public void setInfo_medio_pago5(String info_medio_pago5) {
        this.info_medio_pago5 = info_medio_pago5;
    }

}
