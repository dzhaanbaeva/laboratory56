package com.attractor.laboratory56.util;

import com.attractor.laboratory56.model.Task;
import com.attractor.laboratory56.model.User;
import com.attractor.laboratory56.repository.TaskRepository;
import com.attractor.laboratory56.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class PreloadDataBase {
    @Bean
    CommandLineRunner usersInit(UserRepository userRepo, TaskRepository taskRepo) {
        return (args) -> {
            userRepo.deleteAll();
            taskRepo.deleteAll();


            List<User> users = new ArrayList<>();
            users.add(new User("1","ainura", "ainura@mail.ru",  new BCryptPasswordEncoder().encode("123")));
            users.add(new User("2", "aibek", "aibek@mail.ru",  new BCryptPasswordEncoder().encode("123654")));
            users.add(new User("3", "dastan", "dastan@mail.ru",  new BCryptPasswordEncoder().encode("78965")));
            users.add(new User("4", "aika", "aika@mail.ru",  new BCryptPasswordEncoder().encode("456321")));
            userRepo.saveAll(users);

            List<Task> tasks = new ArrayList<>();
            tasks.add(new Task("1","lesson", "about book",  LocalDate.of(2020,03,20), users.get(1), "new"));
            tasks.add(new Task("2", "attractor", "finish", LocalDate.of(2020,03,15), users.get(0), "In work"));
            tasks.add(new Task("3", "task", "about work", LocalDate.of(2020,03,25), users.get(2), "finish"));
            taskRepo.saveAll(tasks);
        };

        }
    }
