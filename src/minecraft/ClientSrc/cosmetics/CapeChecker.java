package ClientSrc.cosmetics;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {
	
	public static ArrayList<String> owners = new ArrayList<>();
	
	
	
	
	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		
		//Owners
		owners.add("ZombostarkV2");
		
			if(entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && owners.contains(Minecraft.getMinecraft().getSession().getUsername())) {
				return true;
				
			} else {
				return false;
			}
		
			
			
		
		
		
	}

}
