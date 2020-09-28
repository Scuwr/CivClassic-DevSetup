package io.protonull.template.commands;

import java.util.Collections;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import vg.civcraft.mc.civmodcore.command.CivCommand;
import vg.civcraft.mc.civmodcore.command.StandaloneCommand;

/**
 * <p>Example of a standalone command.</p>
 *
 * <p>You do not need to reference this command in any command registrar, just make sure you: a) are not using a
 * legacy command handler, as that takes precedence, and b) have not done {@code this.useNewCommandHandler = false;},
 * and c) have not disabled annotation processing.</p>
 *
 * <p>Use {@link CivCommand} to tag this class as a command handler. All of the command's details are retrieved
 * from any details set in the plugin.yml</p>
 */
@CivCommand(id = "example")
public final class ExampleStandaloneCommand extends StandaloneCommand {

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		sender.sendMessage(ChatColor.GREEN + "You executed the example command :D");
		// Returning true means a successful execution. If you return false then Bukkit will interpret that as the
		// command sender having inputting the command incorrectly.
		return true;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		// Better to return an empty list rather than null, as null may be interpreted
		// as needing to return a list of online players or some other fallback.
		return Collections.emptyList();
	}

}
