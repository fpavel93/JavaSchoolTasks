package forEachWithDelay;

import lombok.SneakyThrows;

import java.util.List;
import java.util.function.Consumer;

public class ForEachWithDelay {

    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<? super T> action)
    {
        for (T t : list) {
            action.accept(t);
            Thread.sleep(delay);
        }
    }
}
