import org.jetbrains.annotations.Contract;

public class Add {

    void add(Integer... numbers) {
        Integer result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
            stringBuilder.append(numbers[i]);
            stringBuilder.append(i == numbers.length - 1 ? "=" : "+");
        }
        System.out.printf("%s%d%n", stringBuilder.toString(), result);
    }
}
