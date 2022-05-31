package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class AntiCobweb extends ModuleMain {
	
	public AntiCobweb() {
		super("AntiCobweb", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.isInWeb = !this.isToggled();
		}
	}

}
