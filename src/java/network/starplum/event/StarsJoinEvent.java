package network.starplum.event;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

public class StarsJoinEvent extends Event {
	
	private ProxiedPlayer player;
	public ProxiedPlayer getPlayer() { return player; }
	public StarsJoinEvent(ProxiedPlayer player) { this.player = player; }

}
