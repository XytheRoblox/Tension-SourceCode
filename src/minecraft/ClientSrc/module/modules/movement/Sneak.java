package ClientSrc.module.modules.movement;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class Sneak extends ModuleMain {
	
	public Sneak() {
		super("Sneak",Keyboard.KEY_Y,Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindSneak.pressed = true;
		}
		super.onUpdate();
	}
	public void onDisable() {
		mc.gameSettings.keyBindSneak.pressed = false;
	}
}
