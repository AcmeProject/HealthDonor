package net.poweredbyhate.healthdonor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lax on 5/11/2016.
 */

public class HealthDonorCommand implements CommandExecutor {

    HealthDonor healthDonor;

    public HealthDonorCommand(HealthDonor healthDonor) {
        this.healthDonor = healthDonor;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;
        if (args.length >= 2 || args.length == 0) {
            p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Usage: " + ChatColor.RED + "/hd <player>");
        }
        if (p.hasPermission("hd.donate") && args.length == 1) {
            if (Bukkit.getPlayerExact(args[0]) == null) {
                p.sendMessage(ChatColor.RED + args[0] + ChatColor.DARK_RED + " is not online!" );
                return false;
            }
            Player p2 = Bukkit.getPlayerExact(args[0]);
            if (p.getUniqueId() == p2.getUniqueId()) { //UUID SUPPORT! 10/10 MORE DOWNLAODS
                p.sendMessage(ChatColor.RED + args[0] + ChatColor.DARK_RED + " is you!" );
                return false;
            }
            if (p.getGameMode() == GameMode.SURVIVAL || p2.getGameMode() == GameMode.SURVIVAL) {
                p.setHealth(0);
                p2.setHealth(p.getMaxHealth());
                ChatColor.translateAlternateColorCodes('&', "&f[&4Health&cDonor&f] &c" + p.getName() + " &4sacrificed their health for &c " + p2.getName());
            } else {
                p.sendMessage(ChatColor.DARK_RED + "Both Parties must be in survival mode to donate/receive health!");
            }
        }

        return false;
    }
}
