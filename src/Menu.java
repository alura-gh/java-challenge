import java.util.Scanner;

public class Menu {
    public void showMenu() {
        System.out.println("*************************************");
        System.out.println("Bienvenido/a al Conversor de Monedas");
        System.out.println("-------------------------------------");
        Converter.inputAPIKey();
        System.out.println("-------------------------------------");
        System.out.println("1. Dólar => Pesos argentinos");
        System.out.println("2. Pesos argentinos => Dólar");
        System.out.println("3. Dólar => Reales brasileños");
        System.out.println("4. Reales brasileños => Dólar");
        System.out.println("5. Dólar => Pesos colombianos");
        System.out.println("6. Pesos colombianos => Dólar");
        System.out.println("7. Salir");
        System.out.println("*************************************");
        inputOption();
    }

    public void inputOption() {
        Scanner scn = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("-------------------------");
            System.out.print("Ingrese una opción: ");
            int option = scn.nextInt();
            continueLoop = chooseOption(option);
        }
        scn.close();
    }

    public double inputValue() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Ingrese el valor a convertir: ");
        return scn.nextDouble();
    }

    private boolean chooseOption(int option) {
        switch (option) {
            case 1:
                Converter converter1 = new Converter("USD", "ARS");
                double value = inputValue();
                converter1.requestAPI(value);
                return true;
            case 2:
                Converter converter2 = new Converter("ARS", "USD");
                double value2 = inputValue();
                converter2.requestAPI(value2);
                return true;
            case 3:
                Converter converter3 = new Converter("USD", "BRL");
                double value3 = inputValue();
                converter3.requestAPI(value3);
                return true;
            case 4:
                Converter converter4 = new Converter("BRL", "USD");
                double value4 = inputValue();
                converter4.requestAPI(value4);
                return true;
            case 5:
                Converter converter5 = new Converter("USD", "COP");
                double value5 = inputValue();
                converter5.requestAPI(value5);
                return true;
            case 6:
                Converter converter6 = new Converter("COP", "USD");
                double value6 = inputValue();
                converter6.requestAPI(value6);
                return true;
            case 7:
                System.out.println("Saliendo del programa...");
                return false;
            default:
                System.out.print("Opcion no válida. ");
                return true;
        }
    }
}
