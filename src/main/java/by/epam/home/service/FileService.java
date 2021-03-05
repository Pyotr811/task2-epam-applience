package by.epam.home.service;

import by.epam.home.entity.Appliance;
import by.epam.home.entity.criteria.Criteria;

public interface FileService {
    Appliance[] find(Criteria criteria) throws FileServiceException;
}
