package ClientSrc.module.modules.combat;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.potion.Potion;

public class AntiPotion extends ModuleMain{
	
	public AntiPotion() {
		super("AntiPotion", 0, Category.COMBAT);
	}
	
	private Potion[] blockedEffects = new Potion[] {Potion.hunger,Potion.moveSlowdown,Potion.digSlowdown,Potion.harm,Potion.confusion,Potion.blindness,Potion.weakness,Potion.wither,Potion.poison};
	
	public void onUpdate() {
		if(!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.onGround && hasBadEffect()) {
			for(int i = 0; i < 100; i++) {
				sendPacket(new C03PacketPlayer());
			}
		}
	}
	
	private boolean hasBadEffect() {
		if(mc.thePlayer.getActivePotionEffects().isEmpty()) {
			return false;
		}
		for(Potion effect : blockedEffects) {
			if(mc.thePlayer.isPotionActive(effect)) {
				return true;
			}
		}
		return false;
	}
}
