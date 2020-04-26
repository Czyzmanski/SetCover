package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.IndexedSetsFamilyMember;
import cover.set.TargetSet;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BruteForceCoverAlgorithm extends CoverAlgorithm {

    private static final int OPTIMAL_SOLUTION_SIZE = 1;

    private int foundSolutionSize;

    public BruteForceCoverAlgorithm() {
        this.foundSolutionSize = Integer.MAX_VALUE;
    }

    @Override
    public void run(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet) {
        this.bruteForce(0, indexedSetsFamily, targetSet, new ArrayList<>());
    }

    private void bruteForce(int memberSetNumber, IndexedSetsFamily indexedSetsFamily,
                            TargetSet targetSet, List<Integer> currentSolution) {
        if (targetSet.isEmpty()) {
            int currentSolutionSize = currentSolution.size();
            if (currentSolutionSize < this.foundSolutionSize) {
                this.foundSolutionSize = currentSolutionSize;
                this.solution = new ArrayList<>(currentSolution);
            }
        } else if (this.bruteForceContinue(memberSetNumber, indexedSetsFamily, targetSet)) {
            IndexedSetsFamilyMember setsFamilyMember = indexedSetsFamily.get(memberSetNumber);
            if (!targetSet.isIntersectionEmpty(setsFamilyMember)) {
                TargetSet newTargetSet = targetSet.removeNumbers(setsFamilyMember);
                currentSolution.add(memberSetNumber);
                this.bruteForce(memberSetNumber + 1, indexedSetsFamily, newTargetSet, currentSolution);
                currentSolution.remove(currentSolution.size() - 1);
            }
            this.bruteForce(memberSetNumber + 1, indexedSetsFamily, targetSet, currentSolution);
        }
    }

    private boolean bruteForceContinue(int memberSetNumber, IndexedSetsFamily indexedSetsFamily, TargetSet targetSet) {
        return memberSetNumber < indexedSetsFamily.size()
                && !targetSet.isEmpty()
                && this.foundSolutionSize != OPTIMAL_SOLUTION_SIZE;
    }

}
