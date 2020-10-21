import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    static String srcText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ultrices "
            + "placerat ante et facilisis. Quisque maximus elementum felis, in vulputate arcu elementum a. In "
            + "tincidunt accumsan velit, non vestibulum diam ultricies sed. Suspendisse molestie magna elit, a "
            + "ultricies felis laoreet ac. Donec venenatis elementum nulla vel commodo. Aliquam pharetra, neque "
            + "et facilisis sodales, lacus lorem iaculis orci, eget molestie neque urna maximus justo. Suspendisse "
            + "viverra ac nisi ac vehicula. Nulla egestas dolor ac nunc cursus, id malesuada massa ornare. Quisque "
            + "mollis tortor vitae fermentum consectetur. Vivamus vel nibh ipsum. Curabitur vel velit ultricies "
            + "libero blandit facilisis. Duis justo tortor, ultrices.";

    public static void main(String[] args) {
        // функция высшего порядка
        Function<String, Set<String>> dictFunc = s -> Arrays.stream(
                s.trim().toLowerCase().replaceAll("\\p{Punct}", "").split("\\s"))
                .collect(Collectors.toSet());
        System.out.println("Словарь аборигенов: ");
        dictFunc.apply(srcText).stream().sorted().forEach(System.out::println); // монада через Stream API
    }
}
