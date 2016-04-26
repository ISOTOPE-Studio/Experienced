package cc.isotopestudio.Experienced.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Experienced.utli.BottleUtli;
import cc.isotopestudio.Experienced.utli.SetExpFix;

public class ItemListener implements Listener {
	@EventHandler
	public void onClickItem(PlayerInteractEvent event) {
		ItemStack item = event.getPlayer().getItemInHand();
		if (BottleUtli.getExp(item) > 0) {
			event.setCancelled(true);
		}
	}

}
