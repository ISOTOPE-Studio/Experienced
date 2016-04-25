package cc.isotopestudio.Experienced.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.Experienced.utli.BottleUtli;
import cc.isotopestudio.Experienced.utli.S;

public class CommandExpStore implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ExpStore")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(S.toPrefixRed("必须要玩家才能执行"));
				return true;
			}
			Player player = (Player) sender;
			ItemStack item = player.getItemInHand();
			if (!item.getType().equals(Material.GLASS_BOTTLE)) {
				player.sendMessage(S.toPrefixRed("你需要一个玻璃瓶"));
				return true;
			}
			if (item.getAmount() != 1) {
				player.sendMessage(S.toPrefixRed("你只能拿着一个玻璃瓶"));
				return true;
			}
			int exp = player.getTotalExperience();
			if (exp <= 0) {
				player.sendMessage(S.toPrefixRed("你没有经验"));
				return true;
			}
			item = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(BottleUtli.itemName);
			List<String> lore = new ArrayList<String>();
			lore.add(S.toBoldDarkGreen(exp + " 点经验"));
			lore.add(S.toYellow("输入 /expget 即可吸收经验"));
			meta.setLore(lore);
			item.setItemMeta(meta);
			player.setItemInHand(item);
			player.setExp(0);
			player.setLevel(0);
			player.setTotalExperience(0);
			player.sendMessage(S.toPrefixGreen("成功储存 " + exp + " 点经验"));
			return true;
		}
		return false;
	}

}
