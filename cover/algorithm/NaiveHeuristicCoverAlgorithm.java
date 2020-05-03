package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.SetsFamilyMember;
import cover.set.SetToCover;

import java.util.ArrayList;

public class NaiveHeuristicCoverAlgorithm extends HeuristicCoverAlgorithm {

    public NaiveHeuristicCoverAlgorithm(SetToCover setToCover, SetsFamily setsFamily) {
        super(setToCover, setsFamily);
    }

    @Override
    public void run() {
        int setsFamilySize = this.setsFamily.size();
        for (int i = 0; i < setsFamilySize && !this.setToCover.isEmpty(); i++) {
            SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
            if (this.setToCover.isIntersectionNonEmpty(setsFamilyMember)) {
                this.setToCover = this.setToCover.removeNumbers(setsFamilyMember);
                this.solution.add(i);
            }
        }

        if (!this.setToCover.isEmpty()) {
            /* Given set to cover has not been covered entirely, so there is no solution. */
            this.solution = new ArrayList<>();
        }
    }

}
