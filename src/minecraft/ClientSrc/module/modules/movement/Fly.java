package ClientSrc.module.modules.movement;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.ModuleMain;
import ClientSrc.module.Category;

public class Fly extends ModuleMain {
	public Fly() {
		super("Fly",0,Category.MOVEMENT);
	}
	
	public void onUpdate() {
		
			mc.thePlayer.capabilities.isFlying = this.isToggled();
			super.onUpdate();
		
	}
	
	
}
