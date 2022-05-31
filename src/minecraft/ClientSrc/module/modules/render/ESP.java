package ClientSrc.module.modules.render;

import ClientSrc.Tension;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import ClientSrc.utils.esp.ChestESPUtils;
import ClientSrc.utils.esp.MobESPUtils;
import de.Hero.settings.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;

public class ESP extends ModuleMain{

	public ESP() {
		super("ESP", 0 , Category.RENDER);
	}
	
	public void setup() {
		Tension.instance.setmgr.rSetting(new Setting("Player", this, false));
		Tension.instance.setmgr.rSetting(new Setting("Chest", this, false));
		Tension.instance.setmgr.rSetting(new Setting("HostileMobs", this, false));
		Tension.instance.setmgr.rSetting(new Setting("FriendlyMobs", this, false));
	}
	
	public void onRender() {
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("Player").getValBoolean()) {
			for(Object e : mc.theWorld.loadedEntityList) {
				if(e instanceof EntityPlayer) {
					MobESPUtils.entityESPBox((Entity)e, 0);
				}
			}
		}
		
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("Chest").getValBoolean()) {
			for(Object o: mc.theWorld.loadedTileEntityList) {
				if(o instanceof TileEntityChest) {
					ChestESPUtils.blockESPBox(((TileEntityChest)o).getPos());
				}
			}
		}
		
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("HostileMobs").getValBoolean()) {
			for(Object h : mc.theWorld.loadedEntityList) {
				if(h instanceof EntityMob) {
					MobESPUtils.entityESPBox((Entity)h, 0);
				}
			}
		}
		
		 if(this.isToggled() && Tension.instance.setmgr.getSettingByName("FriendlyMobs").getValBoolean()) {
			 for(Object f : mc.theWorld.loadedEntityList) {
				 if(f instanceof EntityAnimal) {
					 MobESPUtils.entityESPBox((Entity)f, 0);
				 }
			 }
		 }
	}
	

}