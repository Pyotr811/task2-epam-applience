package by.epam.home.service.impl;

import by.epam.home.dao.FileDAO;
import by.epam.home.dao.FileDAOProvider;
import by.epam.home.entity.Appliance;
import by.epam.home.entity.criteria.Criteria;
import by.epam.home.service.FileService;
import by.epam.home.service.FileServiceException;

import java.io.IOException;

public class FileServiceImpl implements FileService {

    private FileDAOProvider fileDAOProvider = FileDAOProvider.getInstance();
    private FileDAO fileDAO = fileDAOProvider.getFileDAO();


    @Override
    public Appliance[] find(Criteria criteria) throws FileServiceException {
        Appliance[] applianceList = null;
        try {
            applianceList = fileDAO.find(criteria);
        } catch (IOException e) {
            throw new FileServiceException("File service exception");
        }
        return applianceList;
    }
}
