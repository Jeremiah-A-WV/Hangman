class WordBank {
	String[] bankArrayCat = {"Trees", "Colors", "Animals", "Food", "Global Cities"};
		//Array full of words for the categories. Each one is labeled with who created the category
		String[][] bankArray = { {"sequoia", "evergreen", "willow", "palm", "honey"}, //Noah
		{"vermillion", "tangerine", "yellow", "cerulean", "purple"}, //Jeremiah
		{"shark", "sunfish", "owl", "moose", "potoo"}, //Jeff
		{"ramen", "escargot", "poutine", "haggis", "jambalaya"}, //Kayla
		{"tokyo", "venice", "istanbul", "geneva", "philadelphia"} }; //Kevin
		//Array containing hints for the words
		String[][] bankArrayHints = { 
		{"One of the three redwoods...","The name is really on the nose","The sad tree","Tropical staple","Sweet like..."}, //Noah
		{"A MILLION reds","An orange","The sun is . . .","A deep blue","Complementary to yellow"}, //Jeremiah
		{"Bites humans in water","Super flat fish","Who?","Occasional prey to orca","A member of the Nyctibiidae"}, //Jeff
		{"Asian","French","Canadian","Scottish","American"}, //Kayla
		{"Most populated city in the world.","The city of canals.","Eastern Roman Empire capital... renamed.","Place where humanitarian treatment laws for war were established.","Where the Declaration of Independence was signed."} }; //Kevin	
}