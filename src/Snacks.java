import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    //Bloque de tipo static inicializador
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Refresco", 55.88));
        snacks.add(new Snack("Pretzel", 33.99));
        snacks.add(new Snack("Coffee", 26.99));
        snacks.add(new Snack("Chocolate Chip", 8.99));
        snacks.add(new Snack("Mazapán", 5.99));
    }

    public static  void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static  void mostrarSnacks(){
        var inventarioSnacks = "";
        for (Snack snack : snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("Inventario de Snacks: \n" + inventarioSnacks);
    }

    public static  List<Snack> getSnacks(){
        return snacks;
    }
}
