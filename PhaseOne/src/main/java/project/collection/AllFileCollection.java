package project.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class AllFileCollection {

   public static final String folder = "src/main/Collections/";

   //TODO: Possibly use a HashMap? Too complex for now.
    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(folder).toAbsolutePath();
    
    File Dfiles = path.toFile();
       
    public String getName() {
        return folder;
    }
    
    public void print() {
    	System.out.println("Existing Files: ");
    	files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles() {
    	
        File[] CollectionFiles = Dfiles.listFiles();
        
        
        
    	files.clear();
    	for (int i = 0; i < CollectionFiles.length; i++) {
    		if (CollectionFiles[i].isFile()) {
    			files.add(CollectionFiles[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }

    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
    
    
   
    	
    }
    

