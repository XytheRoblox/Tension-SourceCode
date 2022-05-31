package ClientSrc.module.modules.render;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class Zoom extends ModuleMain {
	public Zoom() {
		super("Zoom",0,Category.RENDER);
	}
	
	public float lastFOV = mc.gameSettings.fovSetting;
	
	public void onUpdate() {
		if(this.isToggled() && Keyboard.isKeyDown(Keyboard.KEY_I)) {
			mc.gameSettings.fovSetting = 25;
		
			
		} else {
			mc.gameSettings.fovSetting = lastFOV;
		}
	}
	
}
