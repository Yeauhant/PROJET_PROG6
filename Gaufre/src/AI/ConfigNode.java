package AI;

public class ConfigNode {
	private boolean win;
	private ConfigVector config;
	
	public ConfigNode(boolean win, ConfigVector config) {
		this.win = win;
		this.config = config;
	}
	
	public boolean win() {
		return win;
	}
	
	public ConfigVector config() {
		return config;
	}
	
}
