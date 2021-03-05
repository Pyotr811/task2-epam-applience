package by.epam.home.main;

import by.epam.home.entity.Appliance;
import by.epam.home.entity.criteria.Criteria;
import by.epam.home.service.FileService;
import by.epam.home.service.FileServiceException;
import by.epam.home.service.FileServiceProvider;

public class Main {
    public static void main(String[] args) throws FileServiceException {

        Criteria criteria = new Criteria();

//        criteria.add("color", "blue");
//        criteria.add("DISPLAY_INCHES", 14);

         criteria.add("POWER", 1800);
         criteria.add("PRICE", 10);

//        criteria.add("OS", "Linux");
//        criteria.add("Memory_ROM", 8000);


        FileServiceProvider fileServiceProvider = FileServiceProvider.getInstance();
        FileService fileService = fileServiceProvider.getFileService();

        Appliance[] appliances = fileService.find(criteria);
        for (Appliance appliance :appliances) {
            ConsoleWriter.write(appliance);
        }
    }
}
