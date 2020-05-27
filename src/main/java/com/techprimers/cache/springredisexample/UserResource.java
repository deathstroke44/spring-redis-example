package com.techprimers.cache.springredisexample;


import com.techprimers.cache.springredisexample.model.ID;
import com.techprimers.cache.springredisexample.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add/{roll}/{level}/{name}")
    public User add(@PathVariable("roll") final String roll,
                    @PathVariable("level") final String level,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(new ID(roll, level), name, 20000L));
        return userRepository.findById(new ID(roll, level));
    }

    @GetMapping("/update/{roll}/{level}/{name}")
    public User update(@PathVariable("roll") final String roll,
            @PathVariable("level") final String level,
                       @PathVariable("name") final String name) {
        userRepository.update(new User(new ID(roll, level), name, 1000L));
        return userRepository.findById(new ID(roll, level));
    }
    @GetMapping("/view/{roll}/{level}")
    public User update(@PathVariable("roll") final String roll,
                       @PathVariable("level") final String level) {
        return userRepository.findById(new ID(roll, level));
    }

    @GetMapping("/delete/{roll}/{level}")
    public Map<ID, User> delete(@PathVariable("roll") final String roll,
                                    @PathVariable("level") final String level) {
        userRepository.delete(new ID(roll, level));
        return all();
    }

    @GetMapping("/all")
    public Map<ID, User> all() {
        return userRepository.findAll();
    }
}
