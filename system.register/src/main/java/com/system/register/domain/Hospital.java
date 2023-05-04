package com.system.register.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author mate
 */
@Data                           // Esta anotación es proporcionada por Lombok y se utiliza para generar automáticamente los métodos getter, setter, equals(), hashCode() y toString() de la clase.     
@AllArgsConstructor             // Esta anotación es proporcionada por Lombok crea Constructor CON TODOS LOS ARGUMENTOS
@NoArgsConstructor              // Esta anotación es proporcionada por Lombok crea Constructor SIN LOS ARGUMENTOS
@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    @NotEmpty(message = "Is mandatory")
    private String nombre;

    @Column(name = "salas")
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaHospital> salas;

    @Override
    public String toString() {
        return "Hospital{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + '}';
    }
}
