import domain.Person;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {

        var generator =  new FilePersonReportGenerator("src/main/resources/domain/people.txt");
        generator.generateReport("anyOutput");

    }
}
