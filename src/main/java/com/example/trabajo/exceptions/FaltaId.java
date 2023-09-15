package com.example.trabajo.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FaltaId {

    private String mensaje;
    //private Long idIncorrecto;
}
