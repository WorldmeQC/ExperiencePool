package org.worldme.experiencepool.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.worldme.experiencepool.ExperiencePool;
import org.worldme.experiencepool.util.ConfigUtil;

public class CommandProcess implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("xppool")) {
            if (args.length == 0) {
                sender.sendMessage("用法: /xppool set a 记录当前位置为A");
                sender.sendMessage("用法: /xppool set b 记录当前位置为B");
                sender.sendMessage("用法: /xppool set time x 设置触发周期(毫秒)");
                sender.sendMessage("用法: /xppool set xp x 设置经验值");
                sender.sendMessage("用法: /xppool reload 重载插件配置");
                sender.sendMessage("用法: /xppool info 插件信息");
                return true;
            }
            else if (args.length == 1) {
                // 重载配置
                if (args[0].equalsIgnoreCase("reload")) {
                    ExperiencePool.getInstance().reloadConfig();
                    sender.sendMessage("已重新加载配置!");
                    return true;
                }
                // 插件信息
                if (args[0].equalsIgnoreCase("info")) {
                    sender.sendMessage("插件信息");
                    return true;
                }
            }
            else if (args.length == 2) {

            }
            else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].equalsIgnoreCase("time")) {
                        int time = Integer.parseInt(args[2]);
                        ConfigUtil.config.set("XpPool.Time",time);
                        ConfigUtil.saveConfig();
                        sender.sendMessage("已设置触发周期为 "+ time + " 毫秒");
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
