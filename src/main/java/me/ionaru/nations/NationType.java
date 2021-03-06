package me.ionaru.nations;

public enum NationType {
    ENGLAND(3,"England", "England had a number of colonies in America with Jamestown as the first permanent colony on American soil. Established in the marches of current-day Virginia on May 14, 1607 by the Virginia Company. The town was named after king James I, who ruled over Scotland and England until 1625. \nEngland later captured large parts of East-America in the Anglo-Dutch wars.", "Chance to do extra damage with bow & arrow."),
    NETHERLANDS(2,"Netherlands", "The Netherlands colonized large parts of America's east coast during the 17th century, also known as the Dutch Golden Age. \nNew-Netherland was founded in 1614 with New-Amsterdam as it's capital. New Amsterdam was later captured by the English in the Anglo-Dutch war and renamed to 'New York'.", "Gain a percentage of money each day."),
    SPAIN(1,"Spain", "The very first settlement in the New World was built by Christopher Columbus in 1492 from the remains of the Spanish ship 'The Santa Mar�a', he called it 'La Navidad'. The settlement was on the island what is now known as Haiti. \nSpain went on to colonize the Caribbean Islands, Mexico and large parts of north and south America.", "Chance of extra drops while mining."),
    FRANCE(0,"France", "In the early 17th century, french colonists founded Fort Royal in today's Nova Scotia, Canada. \nNew France was quickly founded as part of the French colonial empire with it's capital: Quebec. New France occupied large parts of North-East Canada and the USA's Midwest until Britain captured the land during several wars.", "Bonus resistance from armor.");

    private int id;
    private String title;
    private String lore;
    private String traits;

    NationType(int id, String title, String lore, String traits){
        this.id = id;
        this.title = title;
        this.lore = lore;
        this.traits = traits;
    }
    
    public int getId(){
        return id;
    }
    
    public static NationType fromId (int id) {
    	if(id == 3) {
    		return ENGLAND;
    	}
    	else if (id == 2) {
    		return NETHERLANDS;
    	}
    	else if (id == 1) {
    		return SPAIN;
    	}
    	else if (id == 0) {
    		return FRANCE;
    	}
    	else {
    		return null;
    	}
    }
    
    public String getTitle(){
        return title;
    }

    public String getTraits(){
        return traits;
    }
    
    public String getLore(){
        return lore;
    }

    public static boolean contains(String text){
        text = text.toUpperCase();
        for(NationType n: NationType.values()){
            if(n.name().equals(text)){
                return true;
            }
        }
        return false;
    }
}