package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new CommandLine(new Help()).execute(args);
    }

}

@Command(mixinStandardHelpOptions = true, version = "help 1.0",
        description = """
                Usage: gendiff [-hV] [-f=format] filepath1 filepath2
                Compares two configuration files and shows a difference.
                      filepath1         path to first file
                      filepath2         path to second file""")
class Help implements Runnable {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"\b\b\b\b-f", "--format"}, //defaultValue = "stylish",
            description = "\b\b=format   output format [default: stylish]")
    boolean value;

    @Override
    public void run() {
    }
}

