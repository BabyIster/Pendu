package fr.babyister.pendu.listener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class ListenerManager {
	
	public static void EnableEvents(Plugin plugin) {
		org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new ListenerChat(), plugin);	
	}

}
