package com.system.register.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mate
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sala_hospital")
public class SalaHospital implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;

    @Column(name = "pacientes")
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paciente> pacientes;

    @Override
    public String toString() {
        return "SalaHospital{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + '}';
    }
}
