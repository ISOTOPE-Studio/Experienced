package cc.isotopestudio.Experienced.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
			
		}
		return false;
	}

}
