package cover.set;

import cover.element.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetsFamily {

    private final List<Set<Element>> sets;

    public SetsFamily() {
        this.sets = new ArrayList<>();
    }

    public void addSet(Set<Element> set) {
        this.sets.add(set);
    }

    public void addToLastSet(Element element) {
        Set<Element> lastSet = this.sets.get(this.sets.size() - 1);
        lastSet.add(element);
    }

    public Set<Element> get(int setNumber) {
        return this.sets.get(setNumber);
    }

    public int numberOfSets() {
        return this.sets.size();
    }

}
