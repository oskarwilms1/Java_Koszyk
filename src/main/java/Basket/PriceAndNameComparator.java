package Basket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

public class PriceAndNameComparator implements Comparator<Product> {
    private final Method methodToCall;
    

    public PriceAndNameComparator(String methodName) {
        try {
            this.methodToCall = Product.class.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Method '" + methodName + "' not found in Product class", e);
        }
    }

    @Override
    public int compare(Product p1, Product p2) {
        try {
            Object value1 = methodToCall.invoke(p1);
            Object value2 = methodToCall.invoke(p2);
            return compareValues(value1, value2);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Error invoking method", e);
        }
    }

    private int compareValues(Object value1, Object value2) {
        // Uses the type of the values to determine the comparison logic.
        return ((Comparable<Object>) value1).compareTo(value2);
    }
}