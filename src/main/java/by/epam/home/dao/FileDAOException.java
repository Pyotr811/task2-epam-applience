package by.epam.home.dao;

public class FileDAOException extends Exception {

    public FileDAOException() {
        super();
    }

    public FileDAOException(String message) {
        super(message);
    }

    public FileDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileDAOException(Throwable cause) {
        super(cause);
    }

    protected FileDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
