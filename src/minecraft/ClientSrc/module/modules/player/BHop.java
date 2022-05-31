package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class BHop extends ModuleMain{
	public BHop() {
		super("BunnyHop",0,Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindJump.pressed = true;
			super.onEnable();
		}
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
		super.onDisable();
	}

}
