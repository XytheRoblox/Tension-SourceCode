package de.Hero.clickgui.util;

import java.awt.Color;

import ClientSrc.Tension;
//Deine Imports


/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int)Tension.instance.setmgr.getSettingByName("GuiRed").getValDouble(), (int)Tension.instance.setmgr.getSettingByName("GuiGreen").getValDouble(), (int)Tension.instance.setmgr.getSettingByName("GuiBlue").getValDouble());
	}
}
