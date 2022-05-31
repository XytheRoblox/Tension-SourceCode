package ClientSrc.module.modules.gui;

import java.util.List;

import org.lwjgl.input.Keyboard;

import ClientSrc.Tension;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TabGui extends ModuleMain {
	public int currentTab;
	public boolean expanded;

	public TabGui() {
		super("TabGui", 0, Category.GUI);
		toggled = true;
	}

	FontRenderer fr = mc.fontRendererObj;

	public void draw() {
		if (this.isToggled()) {
			Gui.drawRect(5, 20, 60, 105, 0x90000000);
			Gui.drawRect(8, 23 + currentTab * 13, 7 + 50, 34 + currentTab * 13, 0xffAA0000);
			int count = 0;

			for (Category c : Category.values()) {
				fr.drawString(c.name, 10, 25 + count * 13, -1);
				count++;
			}
			if (expanded) {
				Category category = Category.values()[currentTab];
				List<ModuleMain> modules = Tension.instance.mm.getModulesByCategory(category);
				if (modules.size() == 0) {
					return;
				}
				Gui.drawRect(60, 20, 60 + 70, 190, 0x90000000);
				Gui.drawRect(60, 23 + category.moduleIndex * 13, 7 + 50 + 67, 34 + category.moduleIndex * 13, 0xffAA0000);
				count = 0;
				for (ModuleMain m : modules) {
					fr.drawStringWithShadow(m.name, 63, 25 + count * 13, -1);
					count++;
				}
			}

		}
	}

	public void keyPressed(int k) {
		Category category = Category.values()[currentTab];
		List<ModuleMain> modules = Tension.instance.mm.getModulesByCategory(category);
		switch(k) {
			case Keyboard.KEY_UP:
				if(expanded) {
					if(category.moduleIndex <= 0) {
						category.moduleIndex = modules.size() - 1;
					}else {
						category.moduleIndex--;
					}		
				}else {
					if(currentTab <= 0) {
						currentTab = Category.values().length - 1;
					}else
						currentTab--;
				}
				
				break;
			case Keyboard.KEY_DOWN:
				if(expanded) {
					if(category.moduleIndex >= modules.size() -1) {
						category.moduleIndex = 0;
					}else {
						category.moduleIndex++;
					}		
				}else {
					if(currentTab >= Category.values().length -1) {
						currentTab = 0;
					}else
						currentTab++;
				}
				
				break;
			case Keyboard.KEY_RIGHT:
				if(expanded && modules.size() != 0) {
					ModuleMain module = modules.get(category.moduleIndex);
					if(!module.name.equals("TabGui") && !module.name.equals("ClickGui")) 
						module.toggle();
						expanded = false;
					}else {
						if(modules.size() != 0) {
							expanded = true;
							category.moduleIndex = 0;
						}
					}
					break;
			case Keyboard.KEY_LEFT:
				expanded = false;
				
				}
				
	
			
		}

}

