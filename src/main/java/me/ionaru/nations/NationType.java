package me.ionaru.nations;

public enum NationType {
    England(3),
    Netherlands(2),
    Spain(1),
    France(0);

    private int id;

    NationType(int id){
        this.id = id;
    }

    public static boolean contains(String text){
        for(NationType n: NationType.values()){
            if(n.name().equals(text)){
                return true;
            }
        }
        return false;
    }
}