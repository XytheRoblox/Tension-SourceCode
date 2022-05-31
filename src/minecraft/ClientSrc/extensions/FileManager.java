package ClientSrc.extensions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ClientSrc.Tension;
import ClientSrc.module.ModuleMain;
import ClientSrc.module.modules.gui.ClickGui;
import ClientSrc.module.modules.misc.SmartDisabler;
import ClientSrc.utils.JSONutils;

public class FileManager {
	
	public static File ROOT_DIR = new File("tension");
	
	public static File modules = new File(ROOT_DIR, "module_states.json");
	
	public void init() {
		
		//Make root dir
		if(!ROOT_DIR.exists()) { ROOT_DIR.mkdirs(); }
		
		if(!modules.exists())
			saveMods();
		 else
			loadMods();
	}
	
	public void saveMods() {
		try {
			JsonObject json = new JsonObject();
			for(ModuleMain mod : Tension.instance.mm.getModules()) {
				JsonObject jsonMod = new JsonObject();
				jsonMod.addProperty("enabled", mod.isToggled());
				json.add(mod.getName(), jsonMod);
			}
			PrintWriter save = new PrintWriter(new FileWriter(modules));
			save.println(JSONutils.prettyGson.toJson(json));
			save.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private HashSet<String> blacklist = Sets.newHashSet(ClickGui.class.getName(), SmartDisabler.class.getName());
	
	public boolean isModBlacklisted(ModuleMain m) {
		return blacklist.contains(m.getClass().getName());
	}
	
	public void loadMods() {
		try {
			BufferedReader load = new BufferedReader(new FileReader(modules));
			JsonObject json = (JsonObject)JSONutils.parser.parse(load);
			load.close();
			Iterator<Entry<String, JsonElement>> itr = json.entrySet().iterator();
			while(itr.hasNext()) {
				Entry<String, JsonElement> entry = itr.next();
				ModuleMain mod = Tension.instance.mm.getModuleByName(entry.getKey());
				if(mod != null && !blacklist.contains(mod.getClass().getName())) {
					JsonObject jsonModule = (JsonObject)entry.getValue();
					boolean enabled = jsonModule.get("enabled").getAsBoolean();
					if(enabled) {
						mod.toggle();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
