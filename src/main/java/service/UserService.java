package service;

import dao.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(String name,int id) throws Exception {
        int i = userMapper.updateUser(name, id);
        return i==1?true:false;
    }

    public User selectUser(int id){
        User user = userMapper.selectUser(id);
        return user;
    }

}