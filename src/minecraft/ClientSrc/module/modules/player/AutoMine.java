package ClientSrc.module.modules.player;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import ClientSrc.utils.Invoker;
import net.minecraft.util.MovingObjectPosition;

public class AutoMine extends ModuleMain{

	public AutoMine() {
		super("AutoMine",0,Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			MovingObjectPosition hover = Invoker.getObjectMouseOver();
			if(hover.typeOfHit != null) {
				if(hover.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					Invoker.setKeyBindAttackPressed(this.isToggled());
				}
			}
		}
	}

}
