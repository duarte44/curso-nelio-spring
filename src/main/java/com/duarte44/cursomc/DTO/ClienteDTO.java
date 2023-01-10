package com.duarte44.cursomc.DTO;

import com.duarte44.cursomc.domain.Cliente;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ClienteDTO implements Serializable {  //serve para q os objetos possam ser gravados em arquivos
    private static final long serialVersion = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max=120, message = "O tamnho deve ser entra 5 e 120 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO(Cliente obj){
        this.id= obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
    }


}
