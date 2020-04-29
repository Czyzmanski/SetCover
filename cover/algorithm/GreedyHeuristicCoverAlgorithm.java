package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.IndexedSetsFamilyMember;
import cover.set.TargetSet;

import java.util.ArrayList;

public class GreedyHeuristicCoverAlgorithm extends HeuristicCoverAlgorithm {

    @Override
    public void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet) {
        int indexedSetsFamilySize = indexedSetsFamily.size();
        boolean[] usedSets = new boolean[indexedSetsFamilySize];
        for (int i = 0; i < indexedSetsFamilySize && !targetSet.isEmpty(); i++) {
            int maxIntersectionSize = 0;
            int maxIntersectionSizeSetNumber = -1;
            for (int j = 0; j < indexedSetsFamilySize; j++) {
                if (!usedSets[j]) {
                    int intersectionSize = targetSet.intersectionSize(indexedSetsFamily.get(j));
                    if (intersectionSize > maxIntersectionSize) {
                        maxIntersectionSize = intersectionSize;
                        maxIntersectionSizeSetNumber = j;
                    }
                }
            }

            if (maxIntersectionSize == 0) {
                break;
            } else {
                IndexedSetsFamilyMember maxIntersectionSizeSet =
                        indexedSetsFamily.get(maxIntersectionSizeSetNumber);
                targetSet = targetSet.removeNumbers(maxIntersectionSizeSet);
                usedSets[maxIntersectionSizeSetNumber] = true;
                this.solution.add(maxIntersectionSizeSetNumber);
            }
        }

        if (!targetSet.isEmpty()) {
            this.solution = new ArrayList<>();
        }
    }

}
