package ClientSrc.module.modules.movement;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class Sprint extends ModuleMain{
	
	public Sprint(){
		super("Sprint", 0,Category.MOVEMENT);
	}
	
	public void onUpdate() {
		
			if(this.isToggled()) {
				if(!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0 && !mc.thePlayer.isSneaking()) {
					mc.thePlayer.setSprinting(toggled);
				}
			}
		
	}
	
	

}
