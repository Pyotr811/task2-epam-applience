package by.epam.home.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private Map<String, Object> criteria = new HashMap<>();

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public void add(String param, Object value){
        criteria.put(param, value);
    }
}
