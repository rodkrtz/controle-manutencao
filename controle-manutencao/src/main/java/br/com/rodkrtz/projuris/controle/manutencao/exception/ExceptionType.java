package br.com.rodkrtz.projuris.controle.manutencao.exception;

public enum ExceptionType {

    NOT_FOUND() {
        @Override
        public void throwException(String message) {
            throw new NotFoundException(message);
        }
    },
    BAD_REQUEST() {
        @Override
        public void throwException(String message) {
            throw new BadRequestException(message);
        }
    },
    NO_CONTENT() {
        @Override
        public void throwException(String message) {

        }
    };

    public abstract void throwException(String message);

    static class NotFoundException extends RuntimeException {

        NotFoundException(String message) {
            super(message);
        }

    }

    static class BadRequestException extends RuntimeException {

        BadRequestException(String message) {
            super(message);
        }

    }

    static class NoContentException extends RuntimeException {

        NoContentException(String message) {
            super(message);
        }

    }

}
