package cover.set;

import cover.element.Element;

import java.util.ArrayList;
import java.util.List;

public class SetsFamily {

    private final List<SetsFamilyMember> sets;

    public SetsFamily() {
        this.sets = new ArrayList<>();
        this.sets.add(new SetsFamilyMember());
    }

    public void addSet(SetsFamilyMember set) {
        this.sets.add(set);
    }

    public void addToLastSet(Element element) {
        SetsFamilyMember lastSet = this.sets.get(this.sets.size() - 1);
        lastSet.add(element);
    }

    public SetsFamilyMember get(int setNumber) {
        return this.sets.get(setNumber);
    }

    public int size() {
        return this.sets.size();
    }

}
