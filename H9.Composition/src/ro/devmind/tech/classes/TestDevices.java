package ro.devmind.tech.classes;

public class TestDevices {

	public static void main(String[] args) {
		Screen aPhoneScreen = new Screen(2400, 1792, 828, 326);
	    Case aPhoneCase = new Case();
	    Speaker aPhoneSpeaker = new Speaker(10);
	    Microphone aPhoneMicrophone = new Microphone(5);
	    Smartphone smartphone = new Smartphone(aPhoneScreen, aPhoneCase, 
	                                           aPhoneSpeaker, aPhoneMicrophone);
	 
	    // in this case we use the 'wrapper' methods, implemented by Smartphone
	    // to press each case button
	    System.out.println("Case 2: use the 'wrapper' methods:");
	    smartphone.pressPowerButton();
	    smartphone.pressVolumeUp();
	    smartphone.pressVolumeDown();
	}

}
