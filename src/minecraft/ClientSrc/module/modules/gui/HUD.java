package ClientSrc.module.modules.gui;

import java.awt.Color;

import java.util.Collections;
import java.util.Comparator;

import ClientSrc.Tension;
import ClientSrc.module.ModuleMain;
import ClientSrc.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	
	public static class ModuleComparator implements Comparator<ModuleMain> {

		@Override
		public int compare(ModuleMain o1, ModuleMain o2) {
			Minecraft mc = Minecraft.getMinecraft();
			if(mc.fontRendererObj.getStringWidth(o1.name) > mc.fontRendererObj.getStringWidth(o2.name)) {
				return -1;
			}
			if(mc.fontRendererObj.getStringWidth(o1.name) < mc.fontRendererObj.getStringWidth(o2.name)) {
				return 1;
			}
			return 0;
		}
		
	}
	
	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		
		Collections.sort(ModuleManager.modules, new ModuleComparator());
		
		fr.drawString(Tension.name + " FPS: " + mc.getDebugFPS(), 4, 4, 0xAA0000);
		
		
		int count = 0;
		for(ModuleMain m : ModuleManager.modules) {
			if(!m.toggled || m.name.equals("TabGUI")) {
				continue;
			}
			
			double offset = count*(fr.FONT_HEIGHT + 6);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(" - " + m.name) - 10, offset, sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, 6 + fr.FONT_HEIGHT + offset, 0xAA0000);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(" - " + m.name) - 8, offset, sr.getScaledWidth(), 6 + fr.FONT_HEIGHT + offset, 0x90000000);
			fr.drawString(" - " + m.name, sr.getScaledWidth() - fr.getStringWidth(" - " + m.name) - 4, 4 + offset, 0xAA0000);
			
			count++;
		}
		
		
	
	}
	
}

