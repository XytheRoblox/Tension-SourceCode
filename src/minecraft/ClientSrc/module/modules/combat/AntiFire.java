package ClientSrc.module.modules.combat;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiFire extends ModuleMain{
	
	public AntiFire() {
		super("AntiFire", 0, Category.COMBAT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isBurning() && !mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.onGround) {
				for(int i = 0; i < 100; i++) {
					sendPacket(new C03PacketPlayer());
				}
			}
		}
	}

}
