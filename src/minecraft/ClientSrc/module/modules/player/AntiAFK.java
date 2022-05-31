package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import ClientSrc.utils.Timers.Timer;
import ClientSrc.utils.Timers.Timer2;

public class AntiAFK extends ModuleMain{
	
	public AntiAFK() {
		super("AntiAFK", 0, Category.PLAYER);
	}
	
	int tickCount = 1;
	int afkCount = 1;
	Timer timer = new Timer();
	Timer2 timer2 = new Timer2();
	
	@Override
	public void onUpdate() {
		
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
			if(timer2.check(500)) {
				mc.thePlayer.rotationYaw = mc.thePlayer.prevRotationYaw -= 90;
			}
		}
		
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
	}

}
