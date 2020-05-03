package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.SetsFamilyMember;
import cover.set.SetToCover;

import java.util.ArrayList;

public class GreedyHeuristicCoverAlgorithm extends HeuristicCoverAlgorithm {

    public GreedyHeuristicCoverAlgorithm(SetToCover setToCover, SetsFamily setsFamily) {
        super(setToCover, setsFamily);
    }

    @Override
    public void run() {
        int setsFamilySize = this.setsFamily.size();
        boolean[] usedSets = new boolean[setsFamilySize];
        for (int i = 0; i < setsFamilySize && !this.setToCover.isEmpty(); i++) {
            int maxIntersectionSize = 0;
            int maxIntersectionSizeSetNumber = -1;
            for (int j = 0; j < setsFamilySize; j++) {
                if (!usedSets[j]) {
                    int intersectionSize = this.setToCover.intersectionSize(setsFamily.get(j));
                    if (intersectionSize > maxIntersectionSize) {
                        maxIntersectionSize = intersectionSize;
                        maxIntersectionSizeSetNumber = j;
                    }
                }
            }

            if (maxIntersectionSize == 0) {
                /* There is no unused set, which has non-empty intersection with subset of set
                 * to cover that has not been covered yet, in the family of sets, so there is
                 * no solution. */
                break;
            } else {
                SetsFamilyMember maxIntersectionSizeSet =
                        this.setsFamily.get(maxIntersectionSizeSetNumber);
                this.setToCover = this.setToCover.removeNumbers(maxIntersectionSizeSet);
                usedSets[maxIntersectionSizeSetNumber] = true;
                this.solution.add(maxIntersectionSizeSetNumber);
            }
        }

        if (!this.setToCover.isEmpty()) {
            /* Given set to cover has not been covered entirely, so there is no solution. */
            this.solution = new ArrayList<>();
        }
    }

}
