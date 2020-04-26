package cover.command;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class CommandParser implements Iterator<Command> {

    private final Scanner inputScanner;

    public CommandParser(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    @Override
    public boolean hasNext() {
        return this.inputScanner.hasNextInt();
    }

    @Override
    public Command next() {
        return null;
    }
}
