package com.example.trabajo.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FaltanDatos {

    private String mensaje;

}
