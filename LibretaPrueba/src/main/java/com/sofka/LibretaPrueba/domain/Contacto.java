package com.sofka.LibretaPrueba.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

//  definicion de la tabla contacto de la bd
@Data
@Entity
@Table(name = "contacto")

public class Contacto implements Serializable {
    //Variable usada para manejar el tema del identificador de la tupla (consecutivo)
    private static final long serialVersionUID = 1L;

    // Identificador de la tupla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id", nullable = false)
    private Integer id;


    //Nombre del contacto
    @Column(name = "cnt_nombre", nullable = false, length = 100)
    private String nombre;

    //Apellidos del contacto
    @Column(name = "cnt_apellido", nullable = false, length = 100)
    private String apellido;

    //Fecha y hora de creación del registro
    @Column(name = "cnt_created_at", nullable = false, updatable = false)
    private Instant createdAt;

    //Fecha y hora de la última actualización
    @Column(name = "cnt_updated_at")
    private Instant updatedAt;

    //cardinalidad 1-n  (un contacto puede tener n telefonos)

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Telefono.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Telefono> telefonos = new ArrayList<>();

}
