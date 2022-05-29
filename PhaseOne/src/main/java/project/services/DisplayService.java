package project.services;

import project.display.Screen;
import project.display.HomeDisplay;
import project.display.MainOptionDisplay;
public class DisplayService {
	
	//static Directory dir = new Directory();
	
	
	
	public static HomeDisplay HomeDisplay = new HomeDisplay();
    public static MainOptionDisplay MainOptionDisplay = new MainOptionDisplay();
    
    

    public static Screen CurrentScreen = HomeDisplay;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    
    
}
