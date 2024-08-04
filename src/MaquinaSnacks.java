import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);

        //Se crea la lista de productos
        List<Snack> productos = new ArrayList<>();
        System.out.println(" *** Maquina de Snacks ***");
        Snacks.mostrarSnacks(); //Se muestra el inventario de snacks disponibles
        while (!salir) {
            try {
                var option = mostrarMenu(consola);
                salir = ejecutarOpciones(option, consola, productos);

            } catch (Exception e) {
                System.out.println("Ocurrió un error; " + e.getMessage());
            } finally {
                System.out.println(); //Imprime un salto de línea con cada iteración
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.println("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo snacks
                4. Salir
                Elige una opción:
                """);
        //Leemos y retornamos la opción seleccionada
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int option, Scanner consola, List<Snack> productos) {
        var salir = false;
        switch (option) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("¡Regresa pronto!");
                salir = true;
            }
            default -> System.out.println("Opción invalida" + option);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.println("¿Que snacks deseas comprar (Id)?");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snack está en la lista
        var snackEncontrado = false;
        for (var snack : Snacks.getSnacks()) {
            if (idSnack == snack.getIdSnack()) {
                //Agregamos el snack a la lista de productos
                productos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("ID de snack no encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = " *** Ticket de Venta *** ";
        var total = 0.0;
        for (var producto : productos) {
            ticket += "\n\t-" + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola) {
        System.out.print("Nombre del Snack: ");
        var nombre = consola.nextLine();
        System.out.print("Precio del Snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("El snack se ha agregado correctamente");
        Snacks.mostrarSnacks();
    }
}
