package ro.devmind.tech.classes;

public class Microphone {
	private int maxVolume;
	private int crtVolume;
	
	public Microphone(int maxVolume, int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}

	public Microphone(int maxVolume) {
		this(maxVolume, (int) (0.25 * maxVolume));
	}
	
	public boolean increaseVolume() {
		if(this.crtVolume < this.maxVolume) {
			this.crtVolume++;
			return true;
		}
		
		return false;
	}
	
	public boolean decreaseVolume() {
		if(this.crtVolume > 0) {
			this.crtVolume--;
			return true;
		}
		
		return false;
	}
	
	public void muteMicrophone() {
		this.crtVolume = 0;
	}
}
