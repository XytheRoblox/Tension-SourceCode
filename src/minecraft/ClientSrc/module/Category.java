package ClientSrc.module;

public enum Category {
	
	COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), RENDER("Render"), GUI("Gui"), MISC("Misc");
	public String name;
	public int moduleIndex;
	Category(String name) {
		this.name = name;
	}

}
