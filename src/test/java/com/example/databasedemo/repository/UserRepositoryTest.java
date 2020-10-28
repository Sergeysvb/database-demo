package com.example.databasedemo.repository;

import com.example.databasedemo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoad (){
        List<User> users = newUsers();
        List<User> savedUsers = userRepository.saveAll(users);
        User anton = userRepository.getOne(savedUsers.get(7).getId());
        Assertions.assertEquals("Anton", anton.getName());
        List<User> allByAgeBetween = userRepository.findAllByAgeBetween(20, 23);
        Assertions.assertEquals(allByAgeBetween.size(),4);
        System.out.println();
    }

    private List<User> newUsers(){
        ArrayList<User> userCollection = new ArrayList<>();
        userCollection.add(new User(null,"Sergey",18,"sergey@email.com"));
        userCollection.add(new User(null,"Oleg",19,"oleg@email.com"));
        userCollection.add(new User(null,"Misha",20,"misha@email.com"));
        userCollection.add(new User(null,"Nikita",21,"nikita@email.com"));
        userCollection.add(new User(null,"Sasha",22,"sasha@email.com"));
        userCollection.add(new User(null,"Petya",23,"petya@email.com"));
        userCollection.add(new User(null,"Igor",24,"igor@email.com"));
        userCollection.add(new User(null,"Anton",25,"anton@email.com"));
        userCollection.add(new User(null,"Lesha",26,"lesha@email.com"));
        userCollection.add(new User(null,"Evgeniy",31,"evgeniy@email.com"));
        return userCollection;
    }
}