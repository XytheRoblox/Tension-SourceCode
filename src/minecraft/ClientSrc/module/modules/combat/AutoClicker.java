package ClientSrc.module.modules.combat;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class AutoClicker extends ModuleMain{
	
	public AutoClicker() {
		super("AutoClicker",0,Category.COMBAT);
	}
	
	ItemStack temp = mc.thePlayer.getHeldItem();
	
	private boolean HoldingAttack = Tension.instance.setmgr.getSettingByName("HoldingAttack").getValBoolean();
	private boolean SwordEquipped = Tension.instance.setmgr.getSettingByName("SwordEquipped").getValBoolean();
	private boolean Normal = Tension.instance.setmgr.getSettingByName("Normal").getValBoolean();
	
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("HoldingAttack");
		options.add("SwordEquipped");
		options.add("Normal");
		Tension.instance.setmgr.rSetting(new Setting("HoldClick", this, false));
		Tension.instance.setmgr.rSetting(new Setting("SwordEquipped", this, true));
		Tension.instance.setmgr.rSetting(new Setting("Normal", this, true));
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			try {
				if(HoldingAttack && mc.thePlayer.keyBindAttack.pressed) {
					mc.thePlayer.setSprinting(true);
					mc.clickMouse();
				} else if(Normal) {
					mc.thePlayer.setSprinting(true);
					mc.clickMouse();
				} else if(SwordEquipped && temp instanceof ItemSword) {
					mc.thePlayer.setSprinting(true);
					mc.clickMouse();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
