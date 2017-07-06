package reflect;
import java.lang.reflect.Field;
public class TestReflect3 {
    private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflect.TestReflect3");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
    }
}