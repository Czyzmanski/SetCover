package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.SetsFamilyMember;
import cover.set.SetToCover;

public class BruteForceCoverAlgorithm extends CoverAlgorithm {

    private boolean solutionFound;

    public BruteForceCoverAlgorithm(SetToCover setToCover, SetsFamily setsFamily) {
        super(setToCover, setsFamily);
        this.solutionFound = false;
    }

    @Override
    public void run() {
        if (this.solutionExists(this.setToCover)) {
            int setsFamilySize = this.setsFamily.size();
            /* Consider subsets of the family of sets, in increasing order of their size. */
            int subsetSize = 1;
            while (subsetSize <= setsFamilySize && !this.solutionFound) {
                int[] subset = new int[subsetSize];
                this.checkSubsets(0, subset, 0, this.setToCover);
                subsetSize++;
            }
        }
    }

    /* Check if there exists any solution, by taking all sets from the family of sets. */
    private boolean solutionExists(SetToCover setToCover) {
        int setsFamilySize = this.setsFamily.size();
        for (int i = 0; i < setsFamilySize && !setToCover.isEmpty(); i++) {
            SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
            setToCover = setToCover.removeNumbers(setsFamilyMember);
        }
        return setToCover.isEmpty();
    }

    /**
     * Recursively check all subsets of the family of sets that can form a solution,
     * with number of elements in a subset equal to subset.length.
     * A subset can form a solution if every set in it covers at least one number from set
     * to be covered.
     * @param i number of currently considered set from the family of sets
     * @param subset array containing numbers of picked sets forming currently considered subset
     * @param added number of sets' numbers added to subset array
     * @param setToCover subset of initial set to cover, that has not been covered yet
     */
    private void checkSubsets(int i, int[] subset, int added, SetToCover setToCover) {
        if (!this.solutionFound) {
            int setsFamilySize = this.setsFamily.size();
            if (added == subset.length) {
                this.checkForSolution(subset, setToCover);
            } else if (subset.length - added == setsFamilySize - i) {
                /* There is no other possibility of forming a subset with given size
                 * than taking all remaining sets in the family of sets. */
                while (added < subset.length) {
                    subset[added] = i;
                    SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
                    setToCover = setToCover.removeNumbers(setsFamilyMember);
                    added++;
                    i++;
                }
                this.checkForSolution(subset, setToCover);
            } else {
                SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
                if (!setToCover.isIntersectionEmpty(setsFamilyMember)) {
                    /* Add currently considered set to the subset and recur for forming
                     * the rest of the subset. */
                    subset[added] = i;
                    SetToCover newSetToCover = setToCover.removeNumbers(setsFamilyMember);
                    this.checkSubsets(i + 1, subset, added + 1, newSetToCover);
                }
                /* Does not add currently considered set to the subset and recur for forming
                 * the rest of the subset. */
                this.checkSubsets(i + 1, subset, added, setToCover);
            }
        }
    }

    /* Check if set to cover has been covered entirely by given subset of the family of sets. */
    private void checkForSolution(int[] subset, SetToCover setToCover) {
        if (setToCover.isEmpty()) {
            this.solutionFound = true;
            for (int i = 0; i < subset.length; i++) {
                this.solution.add(subset[i]);
            }
        }
    }

}