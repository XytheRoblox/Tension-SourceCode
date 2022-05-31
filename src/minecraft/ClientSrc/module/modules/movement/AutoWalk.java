package ClientSrc.module.modules.movement;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class AutoWalk extends ModuleMain {
	public AutoWalk() {
		super("AutoWalk", 0, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
		}
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
		super.onDisable();
	}
}
