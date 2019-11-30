package fr.babyister.pendu.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.babyister.pendu.Pendu;

public class PenduCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Vous n'êtes pas un joueur.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(args.length == 0) {
			
			if(Pendu.get(player) != null ) {
				player.sendMessage("§cVous avez déjà une partie en cours.");
				return true;
			}
			
			player.sendMessage(" ");
			player.sendMessage("§eDébut d'une nouvelle partie.");
			player.sendMessage("§eLe mot à devnier: ");
			player.sendMessage(" ");
			Pendu.init(player);

			
		// SOLUTION	player.sendMessage("§a" + Pendu.get(player).getWord());
			
			return true;
		}
		
		if(args[0].equalsIgnoreCase("stop")) {
			if(Pendu.get(player) == null ) {
				player.sendMessage("§cVous n'avez aucune partie en cours.");
				return true;
			}
			player.sendMessage("§cVous venez de quitter le mdoe de jeux !");
			Pendu.penduP.remove(player);
			return true;
		}
		
		if(args[0].equalsIgnoreCase("help")) {
			player.sendMessage(" ");
			player.sendMessage("§eBienvenue dans l'aide du jeu");
			player.sendMessage(" ");
			player.sendMessage("§e/pendu §7: §aPour lancer une partie");
			player.sendMessage("§e/pendu stop §7: §aPour stoper une partie");

			return true;
		}
		return false;
	}

}
