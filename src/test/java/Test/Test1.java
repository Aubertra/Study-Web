package Test;

import cn.Air_Stack.BaseClass.User;
import cn.Air_Stack.DatabaseOperations.UserManage;
import org.junit.jupiter.api.Test;

public class Test1 {
        @Test
        public void textLogin()  {
            User loginUser =new User("host","Aa824897200.");
            UserManage userManage = new UserManage();
            User user = userManage.login(loginUser);
            System.out.println(user);
        }
}
