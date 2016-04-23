package cc.isotopestudio.Experienced;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.Experienced.command.CommandExpGet;
import cc.isotopestudio.Experienced.command.CommandExpStore;


public class Experienced extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("����").append("]").append(ChatColor.GREEN).toString();
	public static final String pluginName = "Experienced 1.0.0";

	@Override
	public void onEnable() {
		this.getCommand("ExpStore").setExecutor(new CommandExpStore());
		this.getCommand("ExpGet").setExecutor(new CommandExpGet());
		getLogger().info(pluginName + "�ɹ�����!");
		getLogger().info(pluginName + "��ISOTOPE Studio����!");
		getLogger().info("http://isotopestudio.cc");
	}
	
}
