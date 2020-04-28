package cover.set;

import cover.element.Element;

import java.util.ArrayList;
import java.util.List;

public class IndexedSetsFamily {

    private final List<IndexedSetsFamilyMember> sets;

    public IndexedSetsFamily() {
        this.sets = new ArrayList<>();
        this.sets.add(new IndexedSetsFamilyMember());
    }

    public void addSet(IndexedSetsFamilyMember set) {
        this.sets.add(set);
    }

    public void addToLastSet(Element element) {
        IndexedSetsFamilyMember lastSet = this.sets.get(this.sets.size() - 1);
        lastSet.add(element);
    }

    public IndexedSetsFamilyMember get(int setNumber) {
        return this.sets.get(setNumber);
    }

    public int size() {
        return this.sets.size();
    }

}
