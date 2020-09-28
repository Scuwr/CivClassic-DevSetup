package io.protonull.template.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.BukkitCommandCompletionContext;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import java.util.Collections;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import vg.civcraft.mc.civmodcore.ACivMod;
import vg.civcraft.mc.civmodcore.command.AikarCommand;
import vg.civcraft.mc.civmodcore.command.AikarCommandManager;

/**
 * <p>Class to show how to use an Aikar Command Manager and Command.</p>
 *
 * <p>You will need to do the following inside your plugin's class:</p>
 *
 * {@code
 *  private AikarCommandRegistrar commandRegistrar;
 *
 * 	@Override
 * 	public void onEnable() {
 * 		super.onEnable();
 * 		this.commandRegistrar = new AikarCommandRegistrar(this);
 *  }
 *
 *  @Override
 *  public void onDisable() {
 *  	if (this.commandRegistrar != null) {
 *  		this.commandRegistrar.reset();
 *  		this.commandRegistrar = null;
 *  	}
 *  	super.onDisable();
 *  }
 * }
 */
public final class AikarCommandRegistrar extends AikarCommandManager {

	/**
	 * <p>Constructs a new Aikar Command Manager.</p>
	 *
	 * @param plugin The CivModCore plugin instance you're binding this manager to.
	 */
	public AikarCommandRegistrar(ACivMod plugin) {
		super(plugin);
	}

	@Override
	public void registerCommands() {
		registerCommand(new ExampleAikarCommand());
	}

	/**
	 * <p>Example of an Aikar Command.</p>
	 *
	 * <p>This has to extend {@link AikarCommand} rather than the usual {@link BaseCommand}, but other than
	 * that, the rules are the same.</p>
	 *
	 * <p><a href="https://github.com/aikar/commands/wiki">Click here</a> to read more.</p>
	 */
	@CommandAlias("example")
	public static final class ExampleAikarCommand extends AikarCommand {

		/**
		 * <p>Here is a default command handler. The same rules apply here as with standard Aikar commands.</p>
		 *
		 * @param sender The command sender. You can change this parameter to be a Player if you want to limit the
		 * command to players.
		 */
		@Default
		public void defaultHandler(CommandSender sender) {
			sender.sendMessage(ChatColor.GREEN + "You executed the example command :D");
			// Unlike the other handlers, the command is assumed to have been entered correctly unless the parameters
			// do not match. If you want to force a proverbial return false, then throw an exception.
		}

		/**
		 * <p>This is a custom way of defining a tab complete mechanism, which MUST return a String list or null.
		 * The context parameter is not necessary, you can go without, but it's the only valid parameter.</p>
		 *
		 * <p>You're able to able to access this tab complete function the standard way with Aikar commands via the
		 * {@link CommandCompletion} annotation with a "@" prefix.</p>
		 *
		 * <p>Tab completions that already exist:</p>
		 *
		 * <ul>
		 *     <li>@nothing = Deliberately returns nothing</li>
		 *     <li>@range (eg: @range:0-20) = Completes between a range of numbers.</li>
		 *     <li>@mobs = Completes the entries of EntityType.</li>
		 *     <li>@chatcolors = Completes chat colours.</li>
		 *     <li>@worlds = Completes all world names.</li>
		 *     <li>@players = Completes all online players*.</li>
		 *     <li>@materials = Completes all materials.</li>
		 *     <li>@itemMaterials = Completes all item materials.</li>
		 * </ul>
		 */
		@TabComplete("example")
		public List<String> exampleTabList(BukkitCommandCompletionContext context) {
			return Collections.emptyList();
		}

	}

}
