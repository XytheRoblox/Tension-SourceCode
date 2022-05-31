package ClientSrc.command.commands;

import ClientSrc.Tension;
import ClientSrc.command.Command;
import ClientSrc.module.ModuleMain;

public class Toggler extends Command{
	
	public Toggler() {
		super("Toggle","Toggles a module by name","toggle <name>","t");
	}

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length > 0) {
			String moduleName = args[0];
			boolean foundModule = false;
			
			for(ModuleMain m: Tension.instance.mm.getModules()) {
				if(m.name.equalsIgnoreCase(moduleName)) {
					m.toggle();
					
					Tension.instance.mm.sendMessage((m.isToggled() ? "Enabled " + m.name : "Disabled " + m.name));
					foundModule = true;
					break;
				}
			}
			if(!foundModule) {
				Tension.instance.mm.sendMessage(String.format("Module '%s' cannot be found or does not exist", moduleName));
			}
		}
		
	}
	
	

}
