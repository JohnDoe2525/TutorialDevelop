package com.techacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    /**全件を検索して返す*/
    public List<User> getUserList(){
        return userRepository.findAll();

    }

    /**Userの登録を行う*/
    @Transactional
    public User saveUser(User user) {
        //引数で渡したエンティティインスタンスのデータをテーブルに保存
        return userRepository.save(user);
    }
}