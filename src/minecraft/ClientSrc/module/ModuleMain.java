package ClientSrc.module;

import ClientSrc.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;

public class ModuleMain {
	
	protected Minecraft mc = Minecraft.getMinecraft();
	public String name;
	private int key;
	public boolean toggled;
	public Category c;
	
	
	
	public ModuleMain(String nm, int k, Category c) {
		this.name = nm;
		this.key = k;
		this.c = c;
		toggled = false;
		setup();
		
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}

	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}
	public void setup() {}
	public void onEvent(Event e) {}

	public Minecraft getMc() {
		return mc;
	}

	public void setMc(Minecraft mc) {
		this.mc = mc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public Category getCategory() {
		return c;
	}
	
	public void setCategory(Category c) {
		this.c = c;
	}
	protected EntityPlayerSP player() {
		return mc.thePlayer;
	}
	protected PlayerControllerMP playerController() {
		return mc.playerController;
	}
	protected WorldClient world() {
		return mc.theWorld;
	}
	protected void sendPacket(Packet p) {
		player().sendQueue.addToSendQueue(p);
	}
	
	public void enableOnStartUp() {
		toggled = true;
		try {
			toggle();
			onEnable();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
