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
import cc.isotopestudio.Experienced.utli.SetExpFix;

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
			long exp = SetExpFix.getExp(player);
			if (exp <= 0) {
				player.sendMessage(S.toPrefixRed("你没有经验"));
				return true;
			}
			item = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(BottleUtli.itemName);
			List<String> lore = new ArrayList<String>();
			lore.add("§e作用:§a使用后可以增加经验");
			lore.add("§e用法:§a/expshiyong");
			lore.add("§e说明:");
			lore.add("§e-§a当前储存经验: " + exp);
			lore.add("§e-§a(可以从1级升到 " + player.getLevel() + " 级)");
			lore.add("§e-§c一次性道具！请勿右键！");
			meta.setLore(lore);
			item.setItemMeta(meta);
			player.setItemInHand(item);
			SetExpFix.setTotalExperience(player, 0);
			player.sendMessage(S.toPrefixGreen("成功储存 " + exp + " 点经验"));
			return true;
		}
		return false;
	}

}
