package cc.isotopestudio.Experienced.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.Experienced.utli.BottleUtli;
import cc.isotopestudio.Experienced.utli.S;

public class CommandExpGet implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ExpGet")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(S.toPrefixRed("必须要玩家才能执行"));
				return true;
			}
			Player player = (Player) sender;
			ItemStack item = player.getItemInHand();
			if (!item.getType().equals(Material.EXP_BOTTLE)) {
				player.sendMessage(S.toPrefixRed("这不是经验瓶"));
				return true;
			}
			if (item.getAmount() != 1) {
				player.sendMessage(S.toPrefixRed("你只能拿着一个经验瓶"));
				return true;
			}
			int exp = BottleUtli.getExp(item);
			if (exp < 0) {
				player.sendMessage(S.toPrefixRed("这是无效的经验瓶"));
				return true;
			}
			player.setItemInHand(null);
			player.giveExp(exp);
			player.sendMessage(S.toPrefixGreen("成功领回 " + exp + " 点经验"));
			return true;
		}
		return false;
	}

}
