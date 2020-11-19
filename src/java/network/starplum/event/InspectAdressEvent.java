package network.starplum.event;

import net.md_5.bungee.api.plugin.Event;

public class InspectAdressEvent extends Event {
	
	private String adress;
	public String getAdress() { return adress; }
	
	public InspectAdressEvent(String adress) {
		this.adress = adress;
	}
	
}
