import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccentureTest {

    List<Integer> findDuplicates(List<Integer> integerList, int... intValues) {
        Map<Integer, Integer> duplicatesMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        List<Integer> duplicates = integerList;

        for(int value: intValues) {
            duplicates.add(value);
        }

        for(int value: duplicates) {
            if(!duplicatesMap.containsKey(value)) {
                duplicatesMap.put(value, 1);
            } else {
                duplicatesMap.merge(value, 1, Integer::sum);
            }
        }

        for(Map.Entry<Integer, Integer> entry: duplicatesMap.entrySet()) {
            if(entry.getValue() == 2) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> listValues = new ArrayList<>();
        listValues.add(2);
        listValues.add(2);
        listValues.add(2);
        listValues.add(3);
        listValues.add(3);

        List<Integer> duplicates = new AccentureTest().findDuplicates(listValues, 4, 5, 5, 6, 4);

        for(int value: duplicates) {
            System.out.println(value);
        }
    }
}
