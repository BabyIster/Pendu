package fr.babyister.pendu.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.babyister.pendu.Pendu;

public class ListenerChat implements Listener {
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		String message = event.getMessage();
		
		if(Pendu.get(player) != null) {
			
			event.setCancelled(true);
			
			if(message.length() > 1) {
				player.sendMessage("§cVotre message ne peut contenir qu'une lettre à la fois.");
				return;
			}
			
			if(Pendu.get(player).getWord().contains(message)) {		
				Pendu.get(player).letter.add(message);
				Pendu.get(player).GenerateWordsGame();				
				
				if(Pendu.get(player).letter.size() == Pendu.get(player).getWord().length() - 1) {
					
					player.sendMessage(" ");
					player.sendMessage("§eVous avez trouvé le mot ! Félicitation !");
					player.sendMessage("§eLe mot étais: §a" + Pendu.get(player).getWord());
					
					Pendu.penduP.remove(player);
				}
				
			} else {	
				Pendu.get(player).life --;

				if(Pendu.get(player).life == 0) {
					player.sendMessage(" ");
					player.sendMessage("§cVous n'avez plus de vie ! Vous êtes mort !");
					player.sendMessage("§cLe mot étais: §4" + Pendu.get(player).getWord());
					
					Pendu.penduP.remove(player);
					return;
				}
				
				player.sendMessage("§cVotre mot ne contient pas cette lettre.");
				player.sendMessage("§cIl vous reste: §u§e" + Pendu.get(player).life );
				return;
			}
			
		}
		
	}
	

}
