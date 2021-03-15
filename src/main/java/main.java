import composition.InMemoryPersonProvider;
import composition.ReportGenerator;


import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

       // var generator =  new FilePersonReportGenerator("src/main/resources/domain/people.txt");
       // generator.generateReport("PersonInheritance");

        new ReportGenerator(new InMemoryPersonProvider("src/main/resources/domain/people.txt"))
                .generateReport("PersonsComposition");

    }
}
