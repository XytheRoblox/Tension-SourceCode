package ClientSrc.gui;

import ClientSrc.module.modules.gui.Coordinates;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Idk {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	
    Coordinates c = new Coordinates();
   
	
	
	private FontRenderer fr = mc.fontRendererObj;
	
	
	
	
	public void show() {
		fr.drawString("X: " + Math.round(mc.thePlayer.posX) + " Y: " + Math.round(mc.thePlayer.posY) + " Z: " + Math.round(mc.thePlayer.posZ), 165, 5, -1);
	
		
	}
	

}
