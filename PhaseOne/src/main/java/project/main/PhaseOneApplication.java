package project.main;

import project.display.HomeDisplay;



public class PhaseOneApplication {

    public static void main(String[] args) {
    	
    	HomeDisplay welcome = new HomeDisplay();
    	welcome.introWS();
    	welcome.GetUserInput();

    }
}
