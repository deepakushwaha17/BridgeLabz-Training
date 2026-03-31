package annotations;
import java.lang.reflect.Method;

@RoleAllowed("ADMIN")
public class AdminService {

    String currentUserRole = "USER";   
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }   

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Class<?> cls = service.getClass();

        if (cls.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);

            if (roleAllowed.value().equals(service.currentUserRole)) {

                Method method = cls.getDeclaredMethod("deleteUser");
                method.invoke(service);

            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}