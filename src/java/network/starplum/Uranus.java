package network.starplum;

import net.md_5.bungee.api.plugin.Plugin;
import network.starplum.event.caller.EventCaller;
import network.starplum.listeners.GlobalStaffChat;

public class Uranus extends Plugin {
	
	private static Uranus uranus;
	public static Uranus getUranus() { return uranus; }
	
	@Override public void onEnable() {
		new EventCaller();
		new GlobalStaffChat();
	}
	
}
