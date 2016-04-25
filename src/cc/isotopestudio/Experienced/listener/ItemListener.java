package cc.isotopestudio.Experienced.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Experienced.utli.BottleUtli;

public class ItemListener implements Listener {
	@EventHandler
	public void onClickItem(PlayerInteractEvent event) {
		ItemStack item = event.getPlayer().getItemInHand();
		event.getPlayer().sendMessage(BottleUtli.getExp(item) + "");
		if (BottleUtli.getExp(item) > 0) {
			event.setCancelled(true);
		}
	}

}
