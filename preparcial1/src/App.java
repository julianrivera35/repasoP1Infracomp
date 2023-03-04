import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    static Atraccion montanaRusa;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Diga el número de filas que quiere que tenga la atracción");
        int noFilas = Integer.parseInt(scanner.next());

        System.out.println("Diga el número de sillas que quiere que tenga la atracción");
        int noSillas = Integer.parseInt(scanner.next());

        montanaRusa = new Atraccion(noFilas, noSillas);
        
        scanner.close();

        int i = 0;
        while (i < 5){
            int tamMiembro = ThreadLocalRandom.current().nextInt(1, (noSillas/2) + 1);
            Familia familia = new Familia(tamMiembro, montanaRusa, tamMiembro, noFilas);
            familia.start();
            i++;
        }
        



    }
}
