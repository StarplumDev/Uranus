package network.starplum.listeners;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import network.starplum.Uranus;

public class GlobalStaffChat implements Listener {
	
	public GlobalStaffChat() { ProxyServer.getInstance().getPluginManager().registerListener(Uranus.getUranus(), this); }

	@EventHandler public void chatEvent(ChatEvent event) {
		
		if(!(event.getSender() instanceof ProxiedPlayer)) { return; }
		
		final ProxiedPlayer player = (ProxiedPlayer) event.getSender();
		      String message = event.getMessage();
		final boolean hadPermission = player.hasPermission("uranus.staffchat");
		
		if(hadPermission) {
			
			if(message.startsWith("# ") && hadPermission) {
				final String nMessage = message.replace("# ", "");
				BungeeCord.getInstance().getPlayers().forEach(pl -> {
					if(pl.hasPermission("uranus.staffchat")) {
						
						final String serverName = player.getServer().getInfo().getName();
						final String displayServerName = serverName.substring(0, 1).toUpperCase() + serverName.substring(1);
						final TextComponent compo = new TextComponent("§7(§cStaff ▏ §c" + displayServerName + "§7) §f" + player.getName() + "§8➥ §f" + nMessage);
						compo.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server " + serverName));
						compo.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§f§l➔ §fClick to join §c" + serverName).create()));
						
					}
				});
				
			}
			
		}
		
	}
	
}
