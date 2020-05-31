package ro.devmind.tech.classes;

public class Speaker {
	private int maxVolume;
	private int crtVolume;
	
	public Speaker(int maxVolume, int crtVolume) {
		this.maxVolume = maxVolume;
		this.crtVolume = crtVolume;
	}

	public Speaker(int maxVolume) {
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
	
	public void setSilenceMode() {
		this.crtVolume = 0;
	}
}
