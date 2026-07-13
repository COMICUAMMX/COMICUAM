package com.dsge.comicuam.modelos;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("suscripcion")
public class Suscripcion {

    public static final String ESTADO_ACTIVA = "ACTIVA";
    public static final String ESTADO_VENCIDA = "VENCIDA";
    public static final String ESTADO_CANCELADA = "CANCELADA";

    @Id
    @Column("id_suscripcion")
    private Integer idSuscripcion;

    @Column("id_usuario")
    private Long idUsuario;

    @Column("tipo_plan")
    private String tipoPlan;

    @Column("fecha_inicio")
    private LocalDate fechaInicio;

    @Column("fecha_vencimiento")
    private LocalDate fechaVencimiento;

    private String estado;

    public Suscripcion() {
    }

    public Suscripcion(Long idUsuario, String tipoPlan, LocalDate fechaInicio, LocalDate fechaVencimiento) {
        this.idUsuario = idUsuario;
        this.tipoPlan = tipoPlan;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = ESTADO_ACTIVA;
    }

    /**
     * Revisa si la suscripción sigue vigente según la fecha de vencimiento.
     * Actualiza el estado internamente y regresa true si el usuario
     * tiene acceso al contenido premium.
     */
    public boolean validacionAcceso() {
        if (ESTADO_CANCELADA.equals(estado)) {
            return false;
        }

        if (fechaVencimiento != null && fechaVencimiento.isBefore(LocalDate.now())) {
            estado = ESTADO_VENCIDA;
            return false;
        }

        estado = ESTADO_ACTIVA;
        return true;
    }

    /**
     * Cancela el plan manualmente (antes de que llegue la fecha de vencimiento).
     */
    public void cancelarPlan() {
        this.estado = ESTADO_CANCELADA;
    }

    // Getters y setters

    public Integer getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(Integer idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "idSuscripcion=" + idSuscripcion +
                ", idUsuario=" + idUsuario +
                ", tipoPlan='" + tipoPlan + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaVencimiento=" + fechaVencimiento +
                ", estado='" + estado + '\'' +
                '}';
    }
}