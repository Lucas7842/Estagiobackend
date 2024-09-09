package org.example.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

    public Cliente(String cpf) {
        super(cpf); // Chama o construtor da classe pai com o CPF
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() + // Chama getId da classe pai
                ", cpf='" + getIdentificador() + '\'' + // Chama getIdentificador da classe pai
                '}';
    }
}
