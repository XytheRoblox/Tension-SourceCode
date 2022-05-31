package ClientSrc.module;

import java.util.ArrayList;
import java.util.List;

import ClientSrc.Tension;
import ClientSrc.module.modules.combat.*;
import ClientSrc.module.modules.gui.*;
import ClientSrc.module.modules.misc.*;
import ClientSrc.module.modules.movement.*;
import ClientSrc.module.modules.player.*;
import ClientSrc.module.modules.render.*;

import de.Hero.clickgui.ClickGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatComponentText;

public class ModuleManager {

	public static ArrayList<ModuleMain> modules;

	public ModuleManager() {
		modules = new ArrayList<ModuleMain>();
		newMod(new TabGui());
		// Combat
		newMod(new KillAura());
		newMod(new AntiBot());
		newMod(new AntiFire());
		newMod(new AntiPotion());
		newMod(new AutoClicker());
		newMod(new Regen());
		newMod(new FastBow());
		newMod(new Criticals());
		// Movement
		newMod(new Sprint());
		newMod(new AutoWalk());
		newMod(new Fly());
		newMod(new Jetpack());
		newMod(new Parkour());
		newMod(new Sneak());
		newMod(new Scaffold());
		newMod(new Speed());
		newMod(new Step());

		// Player
		newMod(new AntiAFK());
		newMod(new AntiCobweb());
		newMod(new NoFall());
		newMod(new Jesus());
		newMod(new FastPlace());
		newMod(new FastLadder());
		newMod(new BHop());
		newMod(new AutoMine());

		// Render
		newMod(new ClickGui());
		newMod(new FullBright());
		newMod(new Xray());
		newMod(new Coordinates());
		newMod(new Zoom());
		newMod(new ESP());

		// Misc
		newMod(new SmartDisabler());

	}

	public static List<ModuleMain> getModulesByCategory(Category c) {
		List<ModuleMain> modules = new ArrayList<ModuleMain>();

		for (ModuleMain m : Tension.instance.mm.getModules()) {
			if (m.c == c) {
				modules.add(m);
			}

		}
		return modules;
	}

	public void newMod(ModuleMain m) {
		modules.add(m);
	}

	public static ArrayList<ModuleMain> getModules() {
		return modules;
	}

	public static void onUpdate() {
		for (ModuleMain m : modules) {
			m.onUpdate();

		}

	}

	public static void onRender() {
		for (ModuleMain m : modules) {
			m.onRender();
		}
	}

	public static void onKey(int k) {
		for (ModuleMain m : modules) {
			if (m.getKey() == k) {
				m.toggle();
			}
		}
	}

	public static ModuleMain getModuleByName(String moduleName) {
		for (ModuleMain m : Tension.instance.mm.getModules()) {
			if (!m.getName().trim().equalsIgnoreCase(moduleName) && !m.toString().equalsIgnoreCase(moduleName.trim()))
				continue;
			return m;
		}
		return null;
	}

	public static void sendMessage(String message) {
		message = "\u00A74" + Tension.name + "\2477: " + message;

		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}

	public static void sendPacket(Packet p) {
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(p);
	}

}