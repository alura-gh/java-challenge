import java.util.Scanner;

public class Menu {
    public void showMenu() {
        System.out.println("*************************************");
        System.out.println("Bienvenido/a al Conversor de Monedas");
        System.out.println("-------------------------------------");
        System.out.println("1. Dólar => Pesos argentinos");
        System.out.println("2. Pesos argentinos => Dólar");
        System.out.println("3. Dólar => Reales brasileños");
        System.out.println("4. Reales brasileños => Dólar");
        System.out.println("5. Dólar => Pesos colombianos");
        System.out.println("6. Pesos colombianos => Dólar");
        System.out.println("7. Salir");
        System.out.println("*************************************");
    }

    public void inputOption() {
        Scanner scn = new Scanner(System.in);
        boolean iterator;

        do {
            System.out.println("Ingrese una opción:");
            int option = scn.nextInt();
            iterator = chooseOption(option);
        } while (iterator);
    }

    private boolean chooseOption(int option) {
        switch (option) {
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return false;
            case 4:
                return false;
            case 5:
                return false;
            case 6:
                return false;
            case 7:
                return false;
            default:
                System.out.print("Opcion no válida. ");
                return true;
        }
    }
}
