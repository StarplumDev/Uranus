package network.starplum.event.caller;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import network.starplum.Uranus;
import network.starplum.event.InspectAdressEvent;
import network.starplum.event.LobbyJoinEvent;
import network.starplum.event.StaffJoinEvent;
import network.starplum.event.StarsJoinEvent;

public class EventCaller implements Listener {
	
	public EventCaller() { ProxyServer.getInstance().getPluginManager().registerListener(Uranus.getUranus(), this); }

	@EventHandler public void lobbyJoinEvent(ServerConnectEvent event) {
		final ProxiedPlayer player = event.getPlayer();
		final ServerInfo info = player.getServer().getInfo();
		if(info.getName() == "lobby") {
			LobbyJoinEvent lobbyEvent = new LobbyJoinEvent(player);
			ProxyServer.getInstance().getPluginManager().callEvent(lobbyEvent);
		} else if(info.getName() == "star") {
			StarsJoinEvent starsEvent = new StarsJoinEvent(player);
			ProxyServer.getInstance().getPluginManager().callEvent(starsEvent);
		}
	}

	@EventHandler public void staffJoinEvent(PostLoginEvent event) {
		final ProxiedPlayer player = event.getPlayer();
		final ServerInfo info = player.getServer().getInfo();
		if(player.hasPermission("uranus.staff")) {
			StaffJoinEvent staffEvent = new StaffJoinEvent(player, info);
			ProxyServer.getInstance().getPluginManager().callEvent(staffEvent);
		}
	}

	@EventHandler public void inspectAdressEvent(PreLoginEvent event) {
		InspectAdressEvent adressEvent = new InspectAdressEvent(event.getConnection().getVirtualHost().getHostString());
		ProxyServer.getInstance().getPluginManager().callEvent(adressEvent);
	}

}
