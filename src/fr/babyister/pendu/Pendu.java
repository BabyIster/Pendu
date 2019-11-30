package fr.babyister.pendu;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.babyister.pendu.command.PenduCommand;
import fr.babyister.pendu.listener.ListenerManager;


public class Pendu extends JavaPlugin {
	
	public static HashMap<Player, PenduPlayer> penduP = new HashMap<>();
	public static ArrayList<String> words = new ArrayList<>();

	@Override
	public void onEnable() {
		super.onEnable();
		
		words.add("test");
		words.add("chocalat");
		words.add("miel");
		words.add("pepito");
		
		ListenerManager.EnableEvents(this);
		this.getCommand("pendu").setExecutor(new PenduCommand());
		

	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public static PenduPlayer get(Player player) {
		return penduP.get(player);
	}

	public static void init(Player player) {
		if (get(player) == null) {
			penduP.put(player, new PenduPlayer(player));
		}
	}

}
