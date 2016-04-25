package cc.isotopestudio.Experienced.utli;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BottleUtli {
	public static String itemName = S.toBoldGold("经验瓶");

	public static int getExp(ItemStack item) {
		if (!item.getType().equals(Material.EXP_BOTTLE)) {
			return -1;
		}
		try {
			ItemMeta meta = item.getItemMeta();
			if (!meta.getDisplayName().equals(itemName)) {
				return -1;
			}
			for (String lore : meta.getLore()) {
				if (lore.contains("点经验")) {
					return Integer.parseInt(lore.substring(4, lore.indexOf(" ")));
				}
			}
		} catch (Exception e) {
		}
		return -1;
	}
}
