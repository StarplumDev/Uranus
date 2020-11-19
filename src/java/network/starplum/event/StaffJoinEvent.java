package network.starplum.event;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Event;

public class StaffJoinEvent extends Event {

	private ProxiedPlayer player;
	private ServerInfo server;
	public ServerInfo getServer() { return server; }
	public ProxiedPlayer getPlayer() { return player; }

	public StaffJoinEvent(ProxiedPlayer player, ServerInfo server) {
		this.player = player;
		this.server = server;
	}

}
