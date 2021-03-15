import domain.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilePersonReportGenerator extends PersonReportGenerator {

    private final String sourceFile;

    public FilePersonReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    protected List<Person> readPersons() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::readPerson)
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Error reading " + sourceFile);
        }
        return List.of();
    }

    private Person readPerson(String line) {
        String[] personInfo = line.split(",");
        return new Person(personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2]));
    }
}
