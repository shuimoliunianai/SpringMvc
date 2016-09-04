package service;

import dao.UsersDao;
import entity.Users;

import java.util.List;

/**
 * Created by apple on 16/8/24.
 */
public class UserService {
    public UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public int userCount()
    {
        List<Users> lists = usersDao.getAllUser();
        if (lists == null)
        {
            return 0;
        }else{
            return lists.size();
        }
    }
}
