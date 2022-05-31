package ClientSrc.module.modules.combat;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class AutoClicker extends ModuleMain{
	
	public AutoClicker() {
		super("AutoClicker",0,Category.COMBAT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			try {
				mc.thePlayer.setSprinting(true);
				mc.clickMouse();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
