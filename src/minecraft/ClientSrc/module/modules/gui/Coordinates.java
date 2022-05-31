package ClientSrc.module.modules.gui;

import java.util.ArrayList;

import ClientSrc.Tension;

import ClientSrc.module.Category;
import ClientSrc.module.ModuleMain;
import de.Hero.settings.Setting;

public class Coordinates extends ModuleMain {

	public Coordinates() {
		super("Coordinates", 0, Category.GUI);
	}

	

	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("TextColor");
		
	}

	public static boolean enabled = false;

	public void onUpdate() {

		enabled = this.isToggled();

	}

}
