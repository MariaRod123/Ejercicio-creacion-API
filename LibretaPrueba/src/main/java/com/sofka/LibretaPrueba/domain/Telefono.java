package com.sofka.LibretaPrueba.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import lombok.Data;


@Data
@Entity
@Table(name = "telefono")

public class Telefono implements Serializable{
    //Variable usada para manejar el tema del identificador de la tupla (consecutivo)
    private static final long serialVersionUID = 1L;

    //Id de la tupla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_id", nullable = false)
    private Integer id;

    //cardinalidad n - 1 (varios telefonos pueden corresponder a un contacto)

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contacto.class, optional = false)
    @JoinColumn(name = "tel_contacto_id", nullable = false)
    @JsonBackReference
    private Contacto contacto;

    //numero de telefono
    @Column(name = "tel_telefono", nullable = false, length = 30)
    private String telefono;

    // Fecha y hora de registro
    @Column(name = "tel_created_at", nullable = false, updatable = false)
    private Instant createdAt;

    //fecha y hora de la última actualización
    @Column(name = "tel_updated_at")
    private Instant updatedAt;
}
