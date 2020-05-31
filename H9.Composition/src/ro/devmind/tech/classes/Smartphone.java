package ro.devmind.tech.classes;

public class Smartphone {
	private Screen screen;
	private Case theCase;
	private Speaker theSpeaker;
	private Microphone theMicrophone;
	
	private Cover aCover;
	private ScreenProtector aScreenProtector;
	
	public Smartphone(Screen screen, Case theCase, Speaker theSpeaker, Microphone theMicrophone) {
		this.screen = screen;
		this.theCase = theCase;
		this.theSpeaker = theSpeaker;
		this.theMicrophone = theMicrophone;
	}
	
	public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVol,
			int speakerCrtVol, int microMaxVol, int microCrtVol) {
		this.screen = new Screen(pixelsNo, width, length, depth);
		this.theCase = new Case();
		this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
		this.theMicrophone = new Microphone(microMaxVol, microCrtVol);
	}
	
	public boolean setCover(Cover aCover) {
		if (this.aCover != null) {
			System.out.println("Err: A cover is already in place!");
			return false;
		}
		this.aCover = aCover;
		return true;
	}
	
	public Cover removeCover() {
		Cover referenceToCover = this.aCover;
		this.aCover = null;
		return referenceToCover;
	}
	
	public boolean setScreenProtector(ScreenProtector aScreenProtector) {
		if (this.aScreenProtector != null) {
			System.out.println("Err: A screen protector is already in place!");
			return false;
		}
		this.aScreenProtector = aScreenProtector;
		return true;
	}
	
	public ScreenProtector removeScreenProtector() {
		ScreenProtector referenceToScreenProtector = this.aScreenProtector;
		this.aScreenProtector = null;
		return referenceToScreenProtector;
	}
	
	public void pressPowerButton() {
		System.out.print("class Smartphone: delegate to Case -> ");
		this.theCase.pressPowerButton();
	}
	
	public void pressVolumeUp() {
		System.out.print("class Smartphone: delegate to Case -> ");
		this.theCase.pressVolumeUp();
		this.theSpeaker.increaseVolume();
	}
	
	public void pressVolumeDown() {
		System.out.print("class Smartphone: delegate to Case -> ");
		this.theCase.pressVolumeDown();
		this.theSpeaker.decreaseVolume();
	}
	
	public void setPixel(int index, String color) {
		this.screen.setPixel(index, color);
	}
	
	public void colorScreen(String color) {
		this.screen.colorScreen(color);
	}
	
	public boolean increaseMicrophoneVolume() {
		return this.theMicrophone.increaseVolume();
	}
	
	public boolean decreaseMicrophoneVolume() {
		return this.theMicrophone.decreaseVolume();
	}
	
	public void muteMicrophone() {
		this.theMicrophone.muteMicrophone();
	}
	
	public void setSilenceMode() {
		this.theSpeaker.setSilenceMode();
	}
}
