package ClientSrc.module.modules.misc;

import java.util.ArrayList;

import ClientSrc.Tension;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import de.Hero.settings.Setting;

public class SmartDisabler extends ModuleMain{
	
	public SmartDisabler() {
		super("SmartDisabler", 0, Category.MISC);
	}
	
	@Override
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("OnDeath");
		options.add("Normal");
		Tension.instance.setmgr.rSetting(new Setting("OnDeath", this, false));
		Tension.instance.setmgr.rSetting(new Setting("Normal", this, true));
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled() && mc.thePlayer.isDead && Tension.instance.setmgr.getSettingByName("onDeath").getValBoolean()) {
			for(ModuleMain m : Tension.instance.mm.getModules()) {
				
				
				
					m.setToggled(false);
					Tension.instance.mm.sendMessage("Death detected, disabling all modules");
					
				
			}
		}
		if(this.isToggled() && Tension.instance.setmgr.getSettingByName("Normal").getValBoolean()) {
			for(ModuleMain m : Tension.instance.mm.getModules()) {
				
				
				if(m.isToggled()) {
					m.setToggled(false);
					Tension.mm.sendMessage("Disabling Modules");
					
				}
			}
		}
		
	}

}
