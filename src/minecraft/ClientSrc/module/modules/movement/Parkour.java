package ClientSrc.module.modules.movement;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.entity.Entity;

public class Parkour extends ModuleMain{
	
	public Parkour() {
		super("Parkour",0,Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.onGround && !mc.thePlayer.isSneaking() && !this.mc.gameSettings.keyBindSneak.pressed && 
					this.mc.theWorld.getCollidingBoundingBoxes((Entity)mc.thePlayer, mc.thePlayer.getEntityBoundingBox().offset(0.0d, -0.5d, 0.0d).expand(-0.001d,0.0d,-0.001d)).isEmpty()) {
				mc.thePlayer.jump();
			}
		}
		super.onUpdate();
	}

}
