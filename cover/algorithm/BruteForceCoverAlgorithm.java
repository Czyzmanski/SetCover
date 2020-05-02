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
            int combinationSize = 1;
            while (combinationSize <= setsFamilySize && !this.solutionFound) {
                int[] combination = new int[combinationSize];
                this.checkCombinations(0, combination, 0, this.setToCover);
                combinationSize++;
            }
        }
    }

    private boolean solutionExists(SetToCover setToCover) {
        int setsFamilySize = this.setsFamily.size();
        for (int i = 0; i < setsFamilySize && !setToCover.isEmpty(); i++) {
            SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
            setToCover = setToCover.removeNumbers(setsFamilyMember);
        }
        return setToCover.isEmpty();
    }

    private void checkCombinations(int i, int[] combination, int added, SetToCover setToCover) {
        if (!this.solutionFound) {
            int setsFamilySize = this.setsFamily.size();
            if (added == combination.length) {
                this.checkForSolution(combination, setToCover);
            } else if (combination.length - added == setsFamilySize - i) {
                while (added < combination.length) {
                    combination[added] = i;
                    SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
                    setToCover = setToCover.removeNumbers(setsFamilyMember);
                    added++;
                    i++;
                }
                this.checkForSolution(combination, setToCover);
            } else {
                SetsFamilyMember setsFamilyMember = this.setsFamily.get(i);
                if (!setToCover.isIntersectionEmpty(setsFamilyMember)) {
                    combination[added] = i;
                    SetToCover newSetToCover = setToCover.removeNumbers(setsFamilyMember);
                    this.checkCombinations(i + 1, combination, added + 1, newSetToCover);
                }
                this.checkCombinations(i + 1, combination, added, setToCover);
            }
        }
    }

    private void checkForSolution(int[] combination, SetToCover setToCover) {
        if (setToCover.isEmpty()) {
            this.solutionFound = true;
            for (int i = 0; i < combination.length; i++) {
                this.solution.add(combination[i]);
            }
        }
    }

}