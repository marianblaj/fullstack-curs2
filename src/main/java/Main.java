

public class Main {

    public static void main(String[] args) {
        System.out.println(Planet.EUROPA.calculGreutate(87));

        for(Planet planet : Planet.values()){
            System.out.println("Greutate dvs pe planeta "+planet+" ar fi "+ planet.calculGreutate(87)+" kilograme.");
        }
    }

}
