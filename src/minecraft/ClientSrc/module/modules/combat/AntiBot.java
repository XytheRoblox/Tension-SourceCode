package ClientSrc.module.modules.combat;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.entity.Entity;

public class AntiBot extends ModuleMain {
	
	public AntiBot() {
		super("AntiBot",0,Category.COMBAT);
	}
	
	public void onupdate() {
		if(this.isToggled()) {
			for(Object e : mc.theWorld.loadedEntityList) {
				if(((Entity)e).isInvisible() && e != mc.thePlayer) {
					mc.theWorld.removeEntity((Entity)e);
				}
			}
		}
	}

}
