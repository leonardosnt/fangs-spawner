package io.github.leonardosnt.fangsspawner;

import io.github.leonardosnt.fangsspawner.command.SpawnFangsCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class FangsSpawner extends JavaPlugin {

  @Override
  public void onEnable() {
    getCommand("spawnfangs").setExecutor(new SpawnFangsCommand());
  }

}
