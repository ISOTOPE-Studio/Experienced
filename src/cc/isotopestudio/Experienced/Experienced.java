package cc.isotopestudio.Experienced;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.Experienced.command.CommandExpGet;
import cc.isotopestudio.Experienced.command.CommandExpStore;


public class Experienced extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("经验").append("]").append(ChatColor.GREEN).toString();
	public static final String pluginName = "Experienced 1.0.0";

	@Override
	public void onEnable() {
		this.getCommand("ExpStore").setExecutor(new CommandExpStore());
		this.getCommand("ExpGet").setExecutor(new CommandExpGet());
		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}
	
}
