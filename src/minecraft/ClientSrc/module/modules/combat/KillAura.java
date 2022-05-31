package ClientSrc.module.modules.combat;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.ModuleMain;
import ClientSrc.module.Category;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class KillAura extends ModuleMain{
	
	public KillAura() {
		super("KillAura", 0,Category.COMBAT);
	}
	
	public void onUpdate() {
		if(!this.isToggled()) 
			return;
			
		
		
		for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
			Object obj = entities.next();
			if(obj instanceof EntityLivingBase) {
				EntityLivingBase entity = (EntityLivingBase) obj;
				
				if(entity instanceof EntityPlayerSP) continue;
				
				if(mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
					if(entity.isEntityAlive()) {
						mc.playerController.attackEntity(mc.thePlayer, entity);
						mc.thePlayer.swingItem();
						continue;
					}
				}
			}
		}
		super.onUpdate();
	}
		

}
