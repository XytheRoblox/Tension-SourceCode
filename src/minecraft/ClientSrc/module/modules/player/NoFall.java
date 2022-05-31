package ClientSrc.module.modules.player;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.ModuleMain;

import ClientSrc.module.Category;
import net.minecraft.network.play.client.C03PacketPlayer;



public class NoFall extends ModuleMain {
	public NoFall() {
		super("NoFall", Keyboard.KEY_N, Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.fallDistance > 2f) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
			super.onUpdate();
		}
	}
}
