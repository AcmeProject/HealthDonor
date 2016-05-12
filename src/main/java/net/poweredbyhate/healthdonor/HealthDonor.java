package net.poweredbyhate.healthdonor;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lax on 5/11/2016.
 */
public class HealthDonor extends JavaPlugin {

    public void onEnable() {
        getCommand("healthdonor").setExecutor(new HealthDonorCommand(this));
    }
}
