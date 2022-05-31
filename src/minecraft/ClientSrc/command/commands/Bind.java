package ClientSrc.command.commands;

import org.lwjgl.input.Keyboard;

import ClientSrc.Tension;
import ClientSrc.command.Command;
import ClientSrc.module.ModuleMain;

public class Bind extends Command{
	
	public Bind() {
		super("Bind","binds a module by name to a k","bind <name> <key> | clear","b");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 2) {
			String moduleName = args[0];
			String keyName = args[1];
			
			boolean foundModule = false;
			
			for(ModuleMain m : Tension.instance.mm.getModules()) {
				if(m.name.equalsIgnoreCase(moduleName) && !m.name.equalsIgnoreCase("ClickGui")) {
					m.setKey(Keyboard.getKeyIndex(keyName.toUpperCase()));
					
					Tension.instance.mm.sendMessage(String.format("Successfully bound %s to %s",m.name,Keyboard.getKeyName(m.getKey())));
					foundModule = true;
					break;
				} else {
					Tension.instance.mm.sendMessage("Cannot Change the keybind of 'ClickGui'");
					foundModule = true;
					break;
				}
			}
			if(!foundModule) {
				Tension.instance.mm.sendMessage(String.format("Module '%s' cannot be found or does not exist", moduleName));
			}
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("clear")) {
				for(ModuleMain m : Tension.instance.mm.getModules()) {
					if(!m.name.equalsIgnoreCase("ClickGui"))
						m.setKey(Keyboard.KEY_NONE);
				}
			}
			
			Tension.instance.mm.sendMessage("All Module Keybinds Have Been Cleared!");
		}
		
	}

}
