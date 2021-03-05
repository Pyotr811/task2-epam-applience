package by.epam.home.dao.impl;

import by.epam.home.dao.ApplianceFactory;
import by.epam.home.dao.FileDAO;
import by.epam.home.entity.Appliance;
import by.epam.home.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDAOImpl implements FileDAO {

    private final ApplianceFactory applianceFactory = new ApplianceFactory();

    @Override
    public Appliance[] find(Criteria criteria) throws IOException {
        String[] stringApplianceByCriteria = findStringApplianceByCriteria(criteria);
        int length = stringApplianceByCriteria.length;
        Appliance [] applianceList = new Appliance[length];
        int count = 0;
        if (stringApplianceByCriteria[0] != null) {
            for (String app : stringApplianceByCriteria) {
                Appliance appliance = applianceFactory.getObjectFromString(app);
                applianceList[count++] = appliance;
            }
            return applianceList;
        }
        return applianceList;
    }

    private String[] findStringApplianceByCriteria(Criteria criteria) throws IOException {

        String [] matches = new String[1];
        int count = 0;
        String [] appliances = getStringAppliances();
        Map<String, Object> criteriaMap = criteria.getCriteria();

        for (String appliance : appliances) {
            int numberOfMatchesInTheLine = 0;
            for (Map.Entry<String, Object> stringObjectEntry : criteriaMap.entrySet()) {
                Pattern pattern = Pattern.compile("\\s"+stringObjectEntry.getKey().toUpperCase()+"="
                        +stringObjectEntry.getValue()+"(,|$)");
                Matcher matcher = pattern.matcher(appliance);
                if(matcher.find()){
                    numberOfMatchesInTheLine++;
                }
            }
            if(numberOfMatchesInTheLine == criteriaMap.size()){
                int length = matches.length-1;
                if(matches[length]!=null){
                    matches = increaseLengthOfArray(matches);
                }
                matches[count++] = appliance;
            }
        }
        return matches;
    }

    private String[] getStringAppliances() throws IOException {
        int count = 0;
        String [] listAppliance = new String[1];
        File file = new File("appliances_db.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line != null){
            if(!line.isEmpty()){
                if(listAppliance[listAppliance.length-1] != null){
                    listAppliance = increaseLengthOfArray(listAppliance);
                }
                listAppliance[count++] = line;
            }
            line = bufferedReader.readLine();
        }
        return listAppliance;
    }

    private String [] increaseLengthOfArray(String [] array){
        String [] copy = array;
        array = new String[array.length+1];
        for (int i = 0; i < copy.length; i++) {
            array[i] = copy[i];
        }
        return array;
    }


}
