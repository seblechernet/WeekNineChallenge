package com.seb.weekninechallenge.Service;


import com.seb.weekninechallenge.Model.AppUser;
import com.seb.weekninechallenge.Model.Post;
import com.seb.weekninechallenge.Model.Role;
import com.seb.weekninechallenge.Repository.AppUserRepository;
import com.seb.weekninechallenge.Repository.MessageRepository;
import com.seb.weekninechallenge.Repository.PostRepository;
import com.seb.weekninechallenge.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        roleRepository.save(new Role("USER"));

        AppUser user1 = new AppUser();
        AppUser user2 = new AppUser();
        AppUser user3 = new AppUser();

        AppUser profile1 = new AppUser();
        profile1.setEmail("user1@java.com");
        profile1.setFirstName("userfirst");
        profile1.setLastName("userlast");
        profile1.setUserName("user");
        profile1.setPassword("password");
        profile1.setEnabled(true);
        profile1.setAboutYou("I am a Developer");


        userService.saveUser(profile1);


        AppUser profile2 = new AppUser();
        profile2.setEmail("ueser2@java.com");
        profile2.setFirstName("Chernet");
        profile2.setLastName("Seble");
        profile2.setUserName("seb");
        profile2.setPassword("password");
        profile2.setEnabled(true);
        profile2.setAboutYou("I am a Mother of two kids");


        userService.saveUser(profile2);


        AppUser profile3 = new AppUser();
        profile3.setEmail("ueser3@java.com");
        profile3.setFirstName("Will");
        profile3.setLastName("Smith");
        profile3.setUserName("willsmith");
        profile3.setPassword("password");
        profile3.setEnabled(true);
        profile3.setAboutYou("I am an actor");

        userService.saveUser(profile3);



        Post post1=new Post();
        post1.setTitle("Snow");
        post1.setContent("Just saw my first snow ");
        post1.setPostedBy(profile1);

        Post post2=new Post();
        post2.setTitle("WeekEnd");
        post2.setContent("Have a nice weekend!!! ");
        post2.setPostedBy(profile2);

        Post post3=new Post();
        post3.setTitle("My new Movie");
        post3.setContent("My new movie is going to be on cinemas next sunday. hope you will enjoy it ");
        post3.setPostedBy(profile3);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }

    }
