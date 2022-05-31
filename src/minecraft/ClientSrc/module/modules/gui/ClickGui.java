package ClientSrc.module.modules.gui;

import java.util.ArrayList;

import ClientSrc.Tension;
import ClientSrc.module.ModuleMain;
import ClientSrc.module.Category;

import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;

//Deine Imports


/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ClickGui extends ModuleMain{

    

    public ClickGui() {
		super("ClickGui",Keyboard.KEY_RSHIFT,Category.GUI);
		// TODO Auto-generated constructor stub
	}
 	
   
    

	//Setup is called in the Module con
    @Override
    public void setup(){
    	ArrayList<String> options = new ArrayList<>();
    	options.add("JellyLike");
    	options.add("New");
    	Tension.instance.setmgr.rSetting(new Setting("Design", this, "New", options));
    	Tension.instance.setmgr.rSetting(new Setting("Sound", this, false));
    	Tension.instance.setmgr.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
    	Tension.instance.setmgr.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
    	Tension.instance.setmgr.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }
    
    	
    
    @Override
    public void onEnable()
    {
    	/**
    	 * Einfach in der StartMethode
    	 * clickgui = new ClickGUI(); ;)
    	 */
    	
    	mc.displayGuiScreen(Tension.clickgui);
    	toggle();
    	super.onEnable();
    }
}
