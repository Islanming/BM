import com.example.bm.dao.UserDaoImpl;
import com.example.bm.entity.User;
import java.util.List;

/**
 * @author Lenovo
 */
public class test {
    public static void main(String[] args){
        UserDaoImpl dao = new UserDaoImpl();
        List<User> list = dao.list(null);
        for (User user : list){
            System.out.println(user);
        }
    }
}
