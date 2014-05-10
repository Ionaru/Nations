package me.ionaru.nations;

public enum NationType {
    ENGLAND(3,"England", "Extra damage with an axe or sword in combat."),
    NETHERLANDS(2,"Netherlands", "Gain a % of money each day."),
    SPAIN(1,"Spain", "Chance of extra drops while mining."),
    FRANCE(0,"France", "Increase mining speed.");

    private int id;
    private String title;
    private String traits;

    NationType(int id, String title, String traits){
        this.id = id;
        this.traits = traits;
        this.title = title;
    }

    public int getId(){
        return id;
    }

    public String getTraits(){
        return traits;
    }

    public String getTitle(){
        return title;
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