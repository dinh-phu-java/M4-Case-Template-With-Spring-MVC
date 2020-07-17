package com.dinhphu.services.user;

import com.dinhphu.model.User;
import com.dinhphu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices implements IUserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User model) {
        return userRepository.save(model);
    }

    @Override
    public User deleteModel(Integer id) {
        User deleteUser= userRepository.findOne(id);
        userRepository.delete(id);
        return deleteUser;
    }
}
