package cover.algorithm;

import cover.set.SetsFamily;
import cover.set.TargetSet;

import java.io.OutputStream;

public abstract class HeuristicCoverAlgorithm extends CoverAlgorithm {

    public HeuristicCoverAlgorithm(TargetSet targetSet, SetsFamily setsFamily, OutputStream outputStream) {
        super(targetSet, setsFamily, outputStream);
    }

}
