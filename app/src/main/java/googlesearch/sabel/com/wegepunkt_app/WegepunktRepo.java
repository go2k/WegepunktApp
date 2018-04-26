package googlesearch.sabel.com.wegepunkt_app;

import java.util.ArrayList;
import java.util.List;

public class WegepunktRepo {
    private List<WegePunkt> wegePunkte;

    public WegepunktRepo() {
        wegePunkte = new ArrayList<>();
    }

    public void add(WegePunkt wegePunkt){
        if(wegePunkt != null){
            wegePunkte.add(wegePunkt);
        }
    }

    public WegePunkt get(int index){
        if(index < 0 || index >= this.size()){
            return null;
        }

        return wegePunkte.get(index);
    }

    public int size(){
        return wegePunkte.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WegePunkt wegePunkt : wegePunkte) {
            sb.append(wegePunkt.toString());
            sb.append(String.format("%n"));
        }

        return sb.toString();
    }
}
