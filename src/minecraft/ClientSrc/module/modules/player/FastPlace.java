package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class FastPlace extends ModuleMain {
	
	public FastPlace() {
		super("FastPlace",0,Category.PLAYER);
	}
	
	@Override
	
	public void onUpdate() {
		if(this.isToggled()) {
			mc.rightClickDelayTimer = 0;
		}
	}

}
