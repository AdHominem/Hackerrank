import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public class JavaIterator {

    @Contract(pure = true)
    @NotNull
    public static Iterator func(final List list) {
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object element = it.next();
            if (element instanceof String && String.valueOf(element).equals("###")) {
                break;
            }
        }
        return it;
    }
}
