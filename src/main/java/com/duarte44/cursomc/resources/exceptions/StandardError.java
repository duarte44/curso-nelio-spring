package com.duarte44.cursomc.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.security.PrivateKey;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private Long timeStamp;
}
