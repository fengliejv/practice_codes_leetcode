package reflect;
import java.lang.reflect.Field;
public class TestReflect3 {
    private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("reflect.TestReflect3");
        Object obj = clazz.newInstance();
        // ����ֱ�Ӷ� private �����Ը�ֵ
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java�������");
        System.out.println(field.get(obj));
    }
}