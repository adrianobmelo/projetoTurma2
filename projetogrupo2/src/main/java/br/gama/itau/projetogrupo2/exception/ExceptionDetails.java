package br.gama.itau.projetogrupo2.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExceptionDetails {
    private String titulo;
    private String mensagem;
    private int codigoStatus;
    private LocalDateTime timestamp;
}
