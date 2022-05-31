package ClientSrc.module.modules.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import net.minecraft.block.Block;

public class Xray extends ModuleMain {
	
	public static boolean enabled;
	private float oldgamma;
	public ArrayList<Block> xrayblocks = new ArrayList<>();
	
	public Xray() {
		super("Xray",Keyboard.KEY_X,Category.RENDER);
	}
	
	@Override
	public void onEnable() {
		this.enabled = true;
		this.oldgamma = mc.gameSettings.gammaSetting;
		mc.gameSettings.gammaSetting = 10.0f;
		mc.gameSettings.ambientOcclusion = 0;
		mc.renderGlobal.loadRenderers();
	}
	
	@Override
	public void onDisable() {
		this.enabled = false;
		mc.gameSettings.gammaSetting = this.oldgamma;
		mc.gameSettings.ambientOcclusion = 1;
		mc.renderGlobal.loadRenderers();
	}
	
	public boolean xrayblock(Block id) {
		if(this.xrayblocks.contains(id)) {
			return true;
		} else {
			return false;
		}
	}

}
