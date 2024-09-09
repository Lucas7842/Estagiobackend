package org.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "tipo", nullable = false, length = 10)
    private String tipo; // Pode ser "saque" ou "depósito"

    public Transacao(Cliente cliente, Empresa empresa, double valor, String tipo) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return id != null && id.equals(transacao.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", empresa=" + empresa +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
