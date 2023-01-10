package com.duarte44.cursomc.DTO;

import com.duarte44.cursomc.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;



import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO implements Serializable {  //serve para q os objetos possam ser gravados em arquivos
    private static final long serialVersion = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max=80, message = "O tamnho deve ser entra 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
