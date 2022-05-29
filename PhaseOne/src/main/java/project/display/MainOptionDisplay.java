package project.display;


import java.io.File;
import project.collection.AllFileCollection;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class MainOptionDisplay implements Screen {
	
	private AllFileCollection coll = new AllFileCollection();
	
	private ArrayList<String> option = new ArrayList<>();

    public MainOptionDisplay() {
    	
    	option.add("1. Add a File");
        option.add("2. Delete A File");
        option.add("3. Search A File");
        option.add("4. Back to Menu");
        
    }
    
    @Override
    public void Show() {
    	System.out.println("File Options Menu");
        for (String s : option) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
            
          
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    
   

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(AllFileCollection.folder + fileName).toAbsolutePath();
			File file = new File(coll.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  coll.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
	   
        
		Path path = FileSystems.getDefault().getPath(AllFileCollection.folder + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  coll.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
        
        
        ArrayList<File> files = coll.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }

}
