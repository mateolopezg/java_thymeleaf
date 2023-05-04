package com.system.register.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mate
 */
@Data                           // Esta anotación es proporcionada por Lombok y se utiliza para generar automáticamente los métodos getter, setter, equals(), hashCode() y toString() de la clase.     
@AllArgsConstructor             // Esta anotación es proporcionada por Lombok crea Constructor CON TODOS LOS ARGUMENTOS
@NoArgsConstructor              // Esta anotación es proporcionada por Lombok crea Constructor SIN LOS ARGUMENTOS
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "nombre_paciente")
    private String nombrePaciente;

    @Column(name = "edad")
    @NotNull(message = "Years is mandatory")
    private int edad;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "enfermedad")
    @NotEmpty(message = "Enfermedad is mandatory")
    private String enfermedad;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private SalaHospital sala;
}
