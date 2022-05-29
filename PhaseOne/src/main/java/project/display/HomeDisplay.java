package project.display;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import project.services.CollectionService;
import project.services.DisplayService;

public class HomeDisplay implements Screen {

    private String welcomeText = "Welcome to Lockme!";
    private String developerText = "Developer: Shweta Soni";

    private ArrayList<String> options = new ArrayList<>();


    public HomeDisplay() {
        options.add("1. Saved Files");
        options.add("2. File Options Menu");
        options.add("3. Exit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	DisplayService.setCurrentScreen(DisplayService.MainOptionDisplay);
                DisplayService.getCurrentScreen().Show();
                DisplayService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("List of Files: ");
    	CollectionService.PrintFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
