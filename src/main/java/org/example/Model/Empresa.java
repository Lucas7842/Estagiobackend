package org.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa extends Usuario {

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taxa> taxas;

    public Empresa(String cnpj, double saldo, List<Taxa> taxas) {
        super(cnpj); // Chama o construtor da classe pai com o CNPJ
        this.saldo = saldo;
        this.taxas = taxas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + getId() + // Chama getId da classe pai
                ", cnpj='" + getIdentificador() + '\'' + // Chama getIdentificador da classe pai
                ", saldo=" + saldo +
                ", taxas=" + taxas +
                '}';
    }
}
