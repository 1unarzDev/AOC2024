import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ElevenPt2 {
    private static ArrayList<Long> stones;
    private static Map<Integer, int[]> memo = new HashMap<>();
    public static void main(String[] args){
        stones = new ArrayList<>(Arrays.asList(5L, 62914L, 65L, 972L, 0L, 805922L, 6521L, 1639064L));
        blink(75);
        System.out.println(stones.size());
    }

    private static void blink(int times){
        if(times <= 0) return;
        for(int i = stones.size() - 1; i >= 0; i--){
            if(stones.get(i) == 0){
                stones.set(i, 1L);
                continue;
            }

            String convert = String.valueOf(stones.get(i));
            if(convert.length() % 2 == 0) {
                stones.add(i, Long.valueOf(convert.substring(0, convert.length() / 2)));
                stones.set(i + 1, Long.valueOf(convert.substring(convert.length() / 2)));
                continue;
            }

            stones.set(i, stones.get(i) * 2024);
        }
        blink(times - 1);
    }
}