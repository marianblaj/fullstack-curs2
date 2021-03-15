import domain.Person;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

abstract class PersonReportGenerator {

    public void generateReport(String outputFile) throws IOException {
        List<Person> listPersons = readPersons();
        writeSegregatedReport(listPersons, outputFile);

    }

    private void writeSegregatedReport(List<Person> listPerson, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            List<Person> segregatedList = listPerson.stream()
                    .sorted(Comparator.comparing(Person::getAge))
                    .collect(Collectors.toList());

            for (Person person : segregatedList) {
                if (person.getAge() < 30) {
                    if (!checkPraguriVarste(30))
                        writePersonLine(writer, "1-30:");
                    writePersonLine(writer, String.valueOf(person.getFirstName()));
                } else if (person.getAge() > 30 && person.getAge() < 50) {
                    if (!checkPraguriVarste(50))
                        writePersonLine(writer, "30-50:");
                    writePersonLine(writer, String.valueOf(person.getFirstName()));
                } else if (person.getAge() > 60) {
                    if (!checkPraguriVarste(60))
                        writePersonLine(writer, "60++:");
                    writePersonLine(writer, String.valueOf(person.getFirstName()));
                }

            }

        }

    }

    List<Integer> praguriVarste = new ArrayList<Integer>();

    boolean checkPraguriVarste(int age) {

        if (praguriVarste.contains(age))
            return true;
        else {
            praguriVarste.add(age);
            return false;
        }
    }

    private void writePersonLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract List<Person> readPersons();

}
