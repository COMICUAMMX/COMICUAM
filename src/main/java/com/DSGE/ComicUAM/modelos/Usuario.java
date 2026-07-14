package com.dsge.comicuam.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDate;
import lombok.Data;

@Data 
@Table("usuario")
public class Usuario {

    @Id
    private Long id;
    private String nombre;
    private String email;
    private String password; 
    
    @Column("es_suscriptor")
    private boolean esSuscriptor = false; // Por defecto inicia falso (sin suscripción)

    @Column("id_rol")
    private Integer idRol = 1; // Por defecto toma el ID 1 ("sin suscripción")

    @Column("fecha_vencimiento_suscripcion")
    private LocalDate fechaVencimientoSuscripcion; 
}