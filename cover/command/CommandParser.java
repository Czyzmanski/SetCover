package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.element.Element;
import cover.element.ElementBuilder;
import cover.set.SetsFamily;
import cover.set.SetToCover;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandParser implements Iterator<Command> {

    private final SetsFamily setsFamily;
    private final Scanner inputScanner;
    private final OutputStream solutionOutputStream;
    private Integer lastRead;

    public CommandParser(SetsFamily setsFamily,
                         InputStream inputStream, OutputStream solutionOutputStream) {
        this.setsFamily = setsFamily;
        this.inputScanner = new Scanner(inputStream);
        this.solutionOutputStream = solutionOutputStream;
        this.lastRead = null;
    }

    @Override
    public boolean hasNext() {
        return this.inputScanner.hasNextInt();
    }

    @Override
    public Command next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No next command available");
        } else {
            if (this.lastRead == null) {
                this.lastRead = this.inputScanner.nextInt();
            }
            if (this.lastRead < 0) {
                return this.newSolveCoverCommand();
            } else if (this.lastRead == 0) {
                return this.newCreateSetCommand();
            } else {
                return this.newAddElementCommand();
            }
        }
    }

    private Command newSolveCoverCommand() {
        int setToCoverMaxNumber = -this.lastRead;
        int coverAlgorithmType = this.inputScanner.nextInt();
        this.lastRead = null;
        return new SolveCoverCommand(this.setsFamily, setToCoverMaxNumber,
                                     coverAlgorithmType, this.solutionOutputStream);
    }

    private Command newCreateSetCommand() {
        this.lastRead = null;
        return new CreateSetCommand(this.setsFamily);
    }

    private Command newAddElementCommand() {
        ElementBuilder elementBuilder = new ElementBuilder();
        elementBuilder.addParameter(this.lastRead);
        if (this.hasNext()) {
            this.lastRead = this.inputScanner.nextInt();
            if (this.lastRead < 0) {
                elementBuilder.addParameter(-this.lastRead);
                if (this.hasNext()) {
                    this.lastRead = this.inputScanner.nextInt();
                    if (this.lastRead < 0) {
                        elementBuilder.addParameter(-this.lastRead);
                        this.lastRead = null;
                    }
                }
            }
        }
        Element newElement = elementBuilder.buildElement();
        return new AddElementCommand(this.setsFamily, newElement);
    }

}
