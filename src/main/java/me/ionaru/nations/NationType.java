package me.ionaru.nations;

public enum NationType {
    ENGLAND(3, "Extra damage with an axe or sword in combat."),
    NETHERLANDS(2, "Gain a % of money each day."),
    SPAIN(1, "Chance of extra drops while mining."),
    FRANCE(0, "Increase mining speed.");

    private int id;
    private String traits;

    NationType(int id, String traits){
        this.id = id;
        this.traits = traits;
    }

    public int getId(){
        return id;
    }

    public String getTraits(){
        return traits;
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