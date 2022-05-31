package ClientSrc;

import org.lwjgl.opengl.Display;

import ClientSrc.command.CommandManager;
import ClientSrc.event.Event;
import ClientSrc.event.events.EventChat;
import ClientSrc.extensions.DiscordRP;
import ClientSrc.extensions.FileManager;
import ClientSrc.gui.Idk;
import ClientSrc.module.ModuleMain;
import ClientSrc.module.ModuleManager;
import ClientSrc.module.modules.gui.HUD;
import ClientSrc.module.modules.gui.TabGui;
import ClientSrc.utils.alt.AltManager;
import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import net.minecraft.client.Minecraft;

public class Tension {
	
	public static String isMac() {
		if(Minecraft.isRunningOnMac) {
			return "Mac 1.0";
		} else {
			return "1.0";
		}
	}
	
	public static SettingsManager setmgr;
	public static ClickGUI clickgui;
	public static DiscordRP rp = new DiscordRP();
	public static Tension instance = new Tension();
	public static String name = "Tension", version = isMac();
	public static FileManager filemgr;
	public static String fullname = name + " " + version;
	public static HUD h = new HUD();
	public static Idk i = new Idk();
	public static CommandManager cmdManager;
	public static AltManager altManager;
	public static TabGui tabgui;
	
	
	public static ModuleManager mm;
	
	
	
	public static void init() {
		
		
		setmgr = new SettingsManager();
		mm = new ModuleManager();
		clickgui = new ClickGUI();
		altManager = new AltManager();
		h = new HUD();
		i = new Idk();
		filemgr = new FileManager();
		cmdManager = new CommandManager();
		tabgui = new TabGui();
		
		
		filemgr.init();
		rp.start();
		Display.setTitle(fullname);
		
	}
	
	public static void stopClient() {
		Tension.instance.filemgr.saveMods();
	}
	
	public static DiscordRP getDiscordRP()  {
		return rp;
	}
	
	public static void onEvent(Event e) {
		if(e instanceof EventChat) {
			cmdManager.handleChat((EventChat)e);
		}
		for(ModuleMain m : mm.modules) {
			if(!m.toggled) 
				continue;
			m.onEvent(e);
		}
	}

}
