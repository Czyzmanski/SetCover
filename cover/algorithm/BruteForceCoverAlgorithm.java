package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.IndexedSetsFamilyMember;
import cover.set.TargetSet;

public class BruteForceCoverAlgorithm extends CoverAlgorithm {

    private boolean solutionFound;

    public BruteForceCoverAlgorithm() {
        this.solutionFound = false;
    }

    @Override
    public void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet) {
        int n = indexedSetsFamily.size();
        for (int k = 1; k <= n && !this.solutionFound; k++) {
            int[] combination = new int[k];
            this.checkCombination(0, indexedSetsFamily,
                                  combination, 0, targetSet);
        }
    }

    private void checkCombination(int currentIndex, IndexedSetsFamily indexedSetsFamily,
                                  int[] combination, int added, TargetSet targetSet) {
        if (!this.solutionFound) {
            int indexedSetsFamilySize = indexedSetsFamily.size();
            if (added == combination.length) {
                if (targetSet.isEmpty()) {
                    this.solutionFound = true;
                    for (int i = 0; i < combination.length; i++) {
                        this.solution.add(combination[i]);
                    }
                }
            } else if (combination.length - added == indexedSetsFamilySize - currentIndex) {
                while (added < combination.length) {
                    combination[added] = currentIndex;
                    targetSet = targetSet.removeNumbers(indexedSetsFamily.get(currentIndex));
                    added++;
                    currentIndex++;
                }

                if (targetSet.isEmpty()) {
                    this.solutionFound = true;
                    for (int i = 0; i < combination.length; i++) {
                        this.solution.add(combination[i]);
                    }
                }
            } else {
                IndexedSetsFamilyMember setsFamilyMember = indexedSetsFamily.get(currentIndex);
                if (!targetSet.isIntersectionEmpty(setsFamilyMember)) {
                    combination[added] = currentIndex;
                    added++;
                    TargetSet newTargetSet = targetSet.removeNumbers(setsFamilyMember);
                    this.checkCombination(currentIndex + 1, indexedSetsFamily,
                                          combination, added, newTargetSet);
                    added--;
                }
                this.checkCombination(currentIndex + 1, indexedSetsFamily,
                                      combination, added, targetSet);
            }
        }
    }

}
