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
				sender.sendMessage(S.toPrefixRed("����Ҫ��Ҳ���ִ��"));
				return true;
			}
			Player player = (Player) sender;
			ItemStack item = player.getItemInHand();
			if (!item.getType().equals(Material.GLASS_BOTTLE)) {
				player.sendMessage(S.toPrefixRed("����Ҫһ������ƿ"));
				return true;
			}
			if (item.getAmount() != 1) {
				player.sendMessage(S.toPrefixRed("��ֻ������һ������ƿ"));
				return true;
			}
			long exp = SetExpFix.getExp(player);
			if (exp <= 0) {
				player.sendMessage(S.toPrefixRed("��û�о���"));
				return true;
			}
			item = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(BottleUtli.itemName);
			List<String> lore = new ArrayList<String>();
			lore.add("��e����:��aʹ�ú�������Ӿ���");
			lore.add("��e�÷�:��a/expshiyong");
			lore.add("��e˵��:");
			lore.add("��e-��a��ǰ���澭��: " + exp);
			lore.add("��e-��a(���Դ�1������ " + player.getLevel() + " ��)");
			lore.add("��e-��cһ���Ե��ߣ������Ҽ���");
			meta.setLore(lore);
			item.setItemMeta(meta);
			player.setItemInHand(item);
			SetExpFix.setTotalExperience(player, 0);
			player.sendMessage(S.toPrefixGreen("�ɹ����� " + exp + " �㾭��"));
			return true;
		}
		return false;
	}

}
