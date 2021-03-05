package by.epam.home.dao;

import by.epam.home.dao.impl.FileDAOImpl;

public class FileDAOProvider {

    private FileDAOProvider(){}

    private static FileDAOProvider fileDAOProvider;
    private final FileDAO fileDAO = new FileDAOImpl();

    public static FileDAOProvider getInstance(){
        if (fileDAOProvider==null) {
            fileDAOProvider = new FileDAOProvider();
        }
        return fileDAOProvider;
    }

    public FileDAO getFileDAO() {
        return fileDAO;
    }
}
