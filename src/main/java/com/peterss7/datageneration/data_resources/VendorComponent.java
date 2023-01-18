package com.peterss7.datageneration.data_resources;

public enum VendorComponent {

	NOUNS(new String[] {"physics","requirement","bath","profession",
			"throat","wife","revenue","permission","charity","secretary","diamond",
			"entertainment","assumption","opportunity","replacement","information",
			"weakness","farmer","media","reputation","hospital","tradition","artisan",
			"tension","salad","wood","beer","user","philosophy","bedroom","fortune",
			"engine","reality","outcome","climate","shirt","poetry","uncle","skill",
			"topic","disease","response","desk","tennis","death","flight","idea","people",
			"estate","collection","Wish Crane","Elaine Shadowsoul",
			"Annallee Denholm","Asema Crowe","Ayda Victor","Sybil Hunt","Luna Wyrm",
			"Max Murik","Thessalia Grove","Arc Brevil","Roshia Christanti","Sable Howler",
			"Eldia Maganti","Scarlett Soulton","Genevere Lobo","Hazelmere Whitmore",
			"Ilta Cane","Pandora Moonfall","Agnes Krauss","Law Rex","Seraphim Carpathia",
			"Elza Jones","Griffin Sanguine","Eternity Thornton","Arlin Natas",
			"Noirax Depraysie","Margorie Storm","Yao Creighton","Ashen Riddle",
			"Jillia Shadowmend","Quistis Grimsbane","Yellow Stone","Memory Addington",
			"Jinx Void","Twilight Le Torneau","Elphina Skinner","Thistle Aimes",
			"Luce Naxxremis","Lillith Zorander","Ymo Shadowwalker","Morrin Calarook",
			"Adrienne Ripper","Calamity Helion","Zayne Cromwell","Zillah Steros",
			"Lace Jinx","Zima Grail","Gail Panther","Weiss Morelli","Willow Fang"}),
	VERBS(new String[] {"travel","impress","store","praise","collect",
			"convince","decorate","instruct","arrest","agree","quote","gasp","improve",
			"form","fancy","receive","understand","develop","swing","weaken","chat","pay",
			"release","judge","question","exceed","copy","confess","hurry","know","serve",
			"fund","target","spring","strengthen","benefit","test","precede","dedicate",
			"brainstorm","slam","protect","select","prevent","insert","suffer","attach",
			"twist","step","look"});	

	private final String[] array;
	
	VendorComponent(String[] array) {
		this.array = array;
	}
	
	public String[] getArray() {
		return array;	
	}
	
	
}
