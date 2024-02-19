package org.august.luckybreak.main;

import org.august.luckybreak.ConfigManager;
import org.august.luckybreak.commands.LuckyBreakCommands;
import org.august.luckybreak.handlers.BlockBreakEvent;
import org.august.luckybreak.listeners.CommandTabListener;
import org.bukkit.Bukkit;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class LuckyBreak extends JavaPlugin {
    public static LuckyBreak getPlugin() {
        return plugin;
    }

    public static LuckyBreak plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CommandTabListener(), this);

        Objects.requireNonNull(getCommand("luckybreak")).setExecutor(new LuckyBreakCommands());

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();

        initConfig();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.saveConfig();
    }

    private void initConfig() {
        FileConfiguration config = this.getConfig();
        ConfigManager configManager = ConfigManager.getInstance();

        boolean activated = config.getBoolean("activated");
        boolean dropEgs = config.getBoolean("drop_settings.drop_egs");
        boolean dropRequested = config.getBoolean("drop_settings.drop_requested");

        configManager.getConfig().setActivated(activated);
        configManager.getConfig().getDropSettings().setDropEgs(dropEgs);
        configManager.getConfig().getDropSettings().setDropRequested(dropRequested);
    }
}
