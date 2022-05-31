package ClientSrc.module.modules.player;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class FastLadder extends ModuleMain {
	
	private int ticks = 0;
	
	public FastLadder() {
		super("FastLadder",0,Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			ticks++;
			if(mc.thePlayer.isOnLadder() && Keyboard.isKeyDown(Keyboard.KEY_W)) {
				mc.thePlayer.motionY = 2;
			} else if(mc.thePlayer.isOnLadder() && !Keyboard.isKeyDown(Keyboard.KEY_W)) {
				mc.thePlayer.motionY = -2;
			}
		}
	}

}
