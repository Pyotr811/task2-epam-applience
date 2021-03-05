package by.epam.home.dao;

import by.epam.home.entity.Appliance;
import by.epam.home.entity.criteria.Criteria;

import java.io.IOException;

public interface FileDAO {
    Appliance[] find(Criteria criteria) throws IOException;
}
