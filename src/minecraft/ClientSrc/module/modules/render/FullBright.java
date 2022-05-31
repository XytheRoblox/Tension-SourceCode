package ClientSrc.module.modules.render;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class FullBright extends ModuleMain {
	
	public FullBright() {
		super("FullBright", Keyboard.KEY_B,Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100f;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1f;
	}

}
