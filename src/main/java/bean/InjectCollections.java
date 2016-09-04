package bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by apple on 16/8/22.
 */
public class InjectCollections {
    private Set<String> sets;
    private List<String> lists;
    private Map<String,String> maps;

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public String toString()
    {
        return "sets "+sets.toString() + "\nlists "+lists.toString()+"\nmaps "+maps.toString();
    }
}
