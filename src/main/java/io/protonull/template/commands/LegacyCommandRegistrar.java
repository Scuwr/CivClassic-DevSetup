package io.protonull.template.commands;

import java.util.Collections;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import vg.civcraft.mc.civmodcore.command.CommandHandler;
import vg.civcraft.mc.civmodcore.command.PlayerCommand;

/**
 * <p>Class to show how to use a legacy command handler and commands.</p>
 *
 * <p>You will need to do the following inside your plugin's onEnable():</p>
 *
 * {@code
 * 	@Override
 * 	public void onEnable() {
 * 		super.onEnable();
 * 		setCommandHandler(new LegacyCommandRegistrar());
 * 		getCommandHandler().registerCommands();
 *  }
 * }
 */
@SuppressWarnings("deprecation")
public final class LegacyCommandRegistrar extends CommandHandler {

	/**
	 * <p>This is how you register your commands. You have to call this manually.</p>
	 */
	@Override
	public void registerCommands() {
		addCommands(new ExampleLegacyCommand());
	}

	/**
	 * <p>An example of a legacy command.</p>
	 */
	public static final class ExampleLegacyCommand extends PlayerCommand {

		/**
		 * <p>Construct a new example legacy command.</p>
		 */
		public ExampleLegacyCommand() {
			// Command Nice Name
			super("ExampleCommand");
			setIdentifier("example");
			setDescription("This is an example command.");
			setUsage("/example");
			setArguments(0, 0); // No arguments
		}

		@Override
		public boolean execute(CommandSender sender, String[] arguments) {
			sender.sendMessage(ChatColor.GREEN + "You executed the example command :D");
			// Returning true means a successful execution. If you return false then Bukkit will interpret that as the
			// command sender having inputting the command incorrectly.
			return true;
		}

		@Override
		public List<String> tabComplete(CommandSender sender, String[] arguments) {
			// Better to return an empty list rather than null, as null may be interpreted
			// as needing to return a list of online players or some other fallback.
			return Collections.emptyList();
		}

	}

}
