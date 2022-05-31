package ClientSrc.module.modules.combat;

import java.util.ArrayList;

import ClientSrc.Tension;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import de.Hero.settings.Setting;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Criticals extends ModuleMain{

	public Criticals() {
		super("Criticals",0,Category.COMBAT);
	}
	
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("Jump");
		options.add("Packet");
		Tension.instance.setmgr.rSetting(new Setting("Jump",this,true));
		Tension.instance.setmgr.rSetting(new Setting("Packet",this,false));
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("Jump").getValBoolean()) {
			if(mc.objectMouseOver != null && mc.objectMouseOver.entityHit instanceof EntityLivingBase) {
				doJumpCriticals();
			}
		}
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("Packet").getValBoolean()) {
			if(mc.objectMouseOver != null && mc.objectMouseOver.entityHit instanceof EntityLivingBase) {
				doPacketCriticals();
			}
		}
	}
	public void doJumpCriticals() {
		if(!mc.thePlayer.isInWater() && !mc.thePlayer.isInsideOfMaterial(Material.lava) && mc.thePlayer.onGround) {
			mc.thePlayer.motionY = 0.1F;
			mc.thePlayer.fallDistance = 0.1F;
			mc.thePlayer.onGround = false;
		}
	}
	
	public void doPacketCriticals() {
		if(!mc.thePlayer.isInWater() && !mc.thePlayer.isInsideOfMaterial(Material.lava) && mc.thePlayer.onGround) {
			double posX = mc.thePlayer.posX;
			double posY = mc.thePlayer.posY;
			double posZ = mc.thePlayer.posZ;
			
			sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,posY + 0.0625D, posZ, true)); 
			sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,posY, posZ, false)); 
			sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,posY + 1.1E-5D, posZ, false)); 
			sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX,posY, posZ, false)); 
		}
	}

}
