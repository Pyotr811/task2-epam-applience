package by.epam.home.service;

import by.epam.home.service.impl.FileServiceImpl;

public class FileServiceProvider {
    private static FileServiceProvider fileServiceProvider;
    private final FileService fileService = new FileServiceImpl();

    private FileServiceProvider(){}

    public static FileServiceProvider getInstance(){
        if(fileServiceProvider == null){
            fileServiceProvider = new FileServiceProvider();
        }
        return fileServiceProvider;
    }

    public FileService getFileService() {
        return fileService;
    }
}
