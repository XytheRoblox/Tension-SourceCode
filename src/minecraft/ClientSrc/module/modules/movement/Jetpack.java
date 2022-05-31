package ClientSrc.module.modules.movement;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class Jetpack extends ModuleMain {
	public Jetpack() {
		super("Jetpack", 0,Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.gameSettings.keyBindJump.pressed) {
				mc.thePlayer.jump();
			}
		}
	}
}
