package ClientSrc.module.modules.combat;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Regen extends ModuleMain{
	
	public Regen() {
		super("Regen",0,Category.COMBAT);
	}

	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			EntityPlayerSP p = player();
			if(!mc.playerController.isInCreativeMode() && p.getFoodStats().getFoodLevel() > 17 && p.getHealth() < 20 && p.getHealth() != 0 && p.onGround) {
				sendPacket(new C03PacketPlayer());
			}
		}
	}

}
