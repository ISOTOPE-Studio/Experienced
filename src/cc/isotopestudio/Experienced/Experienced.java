package cc.isotopestudio.Experienced;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.Experienced.command.CommandExpGet;
import cc.isotopestudio.Experienced.command.CommandExpStore;
import cc.isotopestudio.Experienced.listener.ItemListener;

public class Experienced extends JavaPlugin {
	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("经验").append("]").append(ChatColor.GREEN).toString();
	public static final String pluginName = "Experienced 1.0.0";

	@Override
	public void onEnable() {
		this.getCommand("ExpStore").setExecutor(new CommandExpStore());
		this.getCommand("ExpGet").setExecutor(new CommandExpGet());

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ItemListener(), this);
		
		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	@Override
	public void onDisable() {
		getLogger().info(pluginName + "成功卸载!");
	}

	public void onReload() {
		this.reloadConfig();
		getLogger().info(pluginName + "成功重载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
	}

}
