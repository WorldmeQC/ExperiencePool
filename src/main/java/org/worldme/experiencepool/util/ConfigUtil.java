package org.worldme.experiencepool.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.worldme.experiencepool.ExperiencePool;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigUtil {
    public static YamlConfiguration config;
    public static void saveDefaultConfig(){
        try {
            File file = ExperiencePool.getInstance().getDataFolder();
            if (!file.exists()) {
                file.mkdirs();
            }
            InputStream resource = ExperiencePool.getInstance().getResource("config.yml");
            if (resource != null) {
                File configFile = new File(file, "config.yml");
                if(!configFile.exists()) {
                    Reader reader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                    config = YamlConfiguration.loadConfiguration(reader);
                    config.save(configFile);
                    ExperiencePool.getInstance().getLogger().info("已生成配置文件！");
                } else {
                    ExperiencePool.getInstance().getLogger().info("检测到配置文件，无需再次生成！");
                    config = YamlConfiguration.loadConfiguration(configFile);
                }
            }
        }catch (IOException e){
            ExperiencePool.getInstance().getLogger().warning(e.toString());
        }
    }

    public static void reloadConfig(){
        File configFile = new File(ExperiencePool.getInstance().getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void saveConfig(){
        File configFile = new File(ExperiencePool.getInstance().getDataFolder(), "config.yml");
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
