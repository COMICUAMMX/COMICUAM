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
    
    @Column("es_suscriptor") // Mapea camelCase a snake_case de la BD
    private boolean esSuscriptor;

    @Column("id_rol")
    private Integer idRol; // Añadido para la relación con la tabla roles

    @Column("fecha_vencimiento_suscripcion")
    private LocalDate fechaVencimientoSuscripcion; // Añadido según tu nueva imagen
}