package com.duarte44.cursomc.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

        private String fieldName;
        private String message;
}
