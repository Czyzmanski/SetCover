package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.SetToCover;

public abstract class HeuristicCoverAlgorithm extends CoverAlgorithm {

    public HeuristicCoverAlgorithm(SetToCover setToCover, SetsFamily setsFamily) {
        super(setToCover, setsFamily);
    }

}
