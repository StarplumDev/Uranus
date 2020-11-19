package network.starplum.event;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

public class LobbyJoinEvent extends Event {
	
	private final ProxiedPlayer player;
	public ProxiedPlayer getPlayer() { return player; }
	public LobbyJoinEvent(ProxiedPlayer player) { this.player = player; }

}
