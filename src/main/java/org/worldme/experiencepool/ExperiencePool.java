package org.worldme.experiencepool;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.worldme.experiencepool.executor.CommandProcess;
import org.worldme.experiencepool.util.ConfigUtil;


public final class ExperiencePool extends JavaPlugin {
    private static ExperiencePool INSTANCE;


    public static ExperiencePool getInstance() {
        return INSTANCE;
    }
    @Override
    public void onEnable() {
        INSTANCE = this;
        // Plugin startup logic
        initPluginCommand();
        ConfigUtil.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initPluginCommand(){
        CommandProcess commandProcess = new CommandProcess();
        Bukkit.getPluginCommand("xppool").setExecutor(commandProcess);
    }

}
