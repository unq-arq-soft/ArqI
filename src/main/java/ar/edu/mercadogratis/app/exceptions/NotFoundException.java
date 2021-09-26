package ar.edu.mercadogratis.app.exceptions;

public class NotFoundException extends ApiException {
    public NotFoundException(String code, String description) {
        super(code, description);
    }
}
