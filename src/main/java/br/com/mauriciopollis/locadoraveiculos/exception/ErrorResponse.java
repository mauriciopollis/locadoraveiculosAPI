package br.com.mauriciopollis.locadoraveiculos.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String mensagem) {
}
