import java.util.ArrayList;
import java.util.List;

public class Melon {

    private final String type;
    private final int weight;
    private final String origin;
    private String getType;

    public Melon(String type, int weight, String origin ) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }
    public static List<Melon> filterByType(List<Melon> melons, String type) {
        List<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType)) {
                result.add(melon);
            }
        }
        return result;

    }
    List<Melon> bailans = filterByType("List", "Danz");
}
