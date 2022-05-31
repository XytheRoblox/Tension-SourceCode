package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

public class Jesus extends ModuleMain {
	
	public Jesus() {
		super("Jesus",0,Category.PLAYER);
	}
	
	public static boolean toggled = false;
	
	public void onUpdate() {
		toggled = this.isToggled();
	}

}
