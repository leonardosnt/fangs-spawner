package io.github.leonardosnt.fangsspawner.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SpawnFangsCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + "This command must be used in-game.");
      return true;
    }
    
    Player player = (Player) sender;
    int amount = 10;
    
    if (args.length > 0) {
      try {
        amount = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        sender.sendMessage(ChatColor.RED + "\"" + args[0] + "\" is not a valid number.");
        return true;
      }
    }
    
    Location start = player.getLocation();
    Vector direction = start.getDirection();

    for (int i = 1; i <= amount; i++) {
      player.getWorld().spawnEntity(start.clone().add(direction.clone().multiply(i)), EntityType.EVOKER_FANGS);
    }
    
    return true;
  }

}
