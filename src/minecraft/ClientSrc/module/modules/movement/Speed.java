package ClientSrc.module.modules.movement;

import java.util.ArrayList;

import ClientSrc.Tension;
import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import de.Hero.settings.Setting;

public class Speed extends ModuleMain{
	
	public Speed() {
		super("Speed",0,Category.MOVEMENT);
	}
	
	private double speed = Tension.instance.setmgr.getSettingByName("Run Speed").getValDouble();
	
	@Override
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("Run Speed");
		Tension.instance.setmgr.rSetting(new Setting("Run Speed", this, speed, 1, 20, false));
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			for(int i = 0; i < Tension.instance.setmgr.getSettingByName("Run Speed").getValDouble(); i++)
				if(mc.thePlayer.onGround) {
					mc.thePlayer.motionX *= 1.1f;
					mc.thePlayer.motionZ *= 1.1f;
			}
		}
	}

}
