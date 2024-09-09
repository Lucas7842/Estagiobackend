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
@Table(name = "taxa")
public class Taxa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor", nullable = false, length = 100)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Taxa(double valor, Empresa empresa) {
        this.valor = valor;
        this.empresa = empresa;
    }
    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if (o == null ||  getClass() != o.getClass()) return false;
        Taxa taxa = (Taxa) o;
        return java.util.Objects.equals(id, taxa.id);

    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(id);
    }
    @Override
    public String toString(){
        return "Taxa{"+
                "id=" + id +
                '}';
    }
}
