package cc.isotopestudio.Experienced.utli;

import org.bukkit.entity.Player;

public class SetExpFix {
	
	public static long getExp(final Player player) {
		int level = player.getLevel();
		double exp = 0;
		if (level <= 16) {
			exp = level * level + 6 * level;
		} else if (level <= 31) {
			exp = 2.5 * level * level - 40.5 * level + 360;
		} else {
			exp = 4.5 * level * level - 162.5 * level + 2220;
		}
		exp += getExpAtLevel(level) * player.getExp();
		return (long) (exp + 0.5);
	}

	public static long getExpAtLevel(int level) {
		long exp = 0;
		if (level <= 16) {
			exp = 2 * level + 7;
		} else if (level <= 31) {
			exp = 5 * level - 38;
		} else {
			exp = 9 * level - 158;
		}
		return exp;
	}

	// This method is used to update both the recorded total experience and
	// displayed total experience.
	// We reset both types to prevent issues.
	public static void setTotalExperience(final Player player, final int exp) {
		if (exp < 0) {
			throw new IllegalArgumentException("Experience is negative!");
		}
		player.setExp(0);
		player.setLevel(0);
		player.setTotalExperience(0);
	}

}
