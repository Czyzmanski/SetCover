package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.IndexedSetsFamilyMember;
import cover.set.TargetSet;

public class NaiveHeuristicCoverAlgorithm extends HeuristicCoverAlgorithm {

    @Override
    public void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet) {
        int indexedSetFamilySize = indexedSetsFamily.size();
        for (int i = 0; i < indexedSetFamilySize && !targetSet.isEmpty(); i++) {
            IndexedSetsFamilyMember setsFamilyMember = indexedSetsFamily.get(i);
            if (!targetSet.isIntersectionEmpty(setsFamilyMember)) {
                targetSet = targetSet.removeNumbers(setsFamilyMember);
                this.solution.add(i + 1);
            }
        }

        if (!targetSet.isEmpty()) {
            this.solution.clear();
        }
    }

}
