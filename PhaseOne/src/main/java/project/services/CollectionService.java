package project.services;

import java.io.File;

import project.collection.AllFileCollection;




public class CollectionService {

    private static AllFileCollection fileDirectory = new AllFileCollection();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : CollectionService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static AllFileCollection getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(AllFileCollection fileDirectory) {
        CollectionService.fileDirectory = fileDirectory;
    }


}
