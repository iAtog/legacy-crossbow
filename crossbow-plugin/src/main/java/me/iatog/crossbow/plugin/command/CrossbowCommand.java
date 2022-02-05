package me.iatog.crossbow.plugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.iatog.crossbow.plugin.util.StringUtil.colorize;

public class CrossbowCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String unknownCommand = "&cUnknown sub-command, do &7/" + label + " help &cfor more info";

		if (args.length > 0) {
			switch (args[0]) {

			case "help":

				break;
			
			case "item":
			case "crossbow":
				
				break;
				
			default:
				sender.sendMessage(colorize(unknownCommand));
				break;
			}
		} else {
			sender.sendMessage(colorize(unknownCommand));
		}
		return true;
	}

}
