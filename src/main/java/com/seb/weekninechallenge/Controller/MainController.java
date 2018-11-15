package com.seb.weekninechallenge.Controller;


import com.cloudinary.utils.ObjectUtils;
import com.seb.weekninechallenge.Configuration.CloudinaryConfig;
import com.seb.weekninechallenge.Model.AppUser;
import com.seb.weekninechallenge.Model.Post;
import com.seb.weekninechallenge.Repository.AppUserRepository;
import com.seb.weekninechallenge.Repository.MessageRepository;
import com.seb.weekninechallenge.Repository.PostRepository;
import com.seb.weekninechallenge.Repository.RoleRepository;
import com.seb.weekninechallenge.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserService userService;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/userPage")
    public String list(Model model) {

        model.addAttribute("posts", postRepository.findAll());

        return "userpage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterationPage(Model model) {
        model.addAttribute("appUser", new AppUser());

        return "registrationform";
    }


    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String showRegestrationPage(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model,@RequestParam MultipartFile file){
        model.addAttribute("appUser",appUser);

        if (file.isEmpty()){
            return "redirect:/add";
        }
        try{

            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
            appUser.setPicture(uploadResult.get("url").toString());
            userService.saveUser(appUser);

        }
        catch (IOException e){
            e.printStackTrace();
            return "redirect:/registration";
        }
        if (result.hasErrors())
        {
            return "redirecr:/registration";
        }

        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/post")
    public String addAccount(Model model){

        model.addAttribute("post",new Post());

        return "write";
    }
    @PostMapping("/process")
    public String process(Post post, Authentication auth){

        AppUser appUser=appUserRepository.findByUserName(auth.getName());
        post.setPostedBy(appUser);
        postRepository.save(post);
//        if (file.isEmpty()){
//            return "redirect:/add";
//        }
//        try{
//            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
//            room.setPic(uploadResult.get("url").toString());
//            AppUser appUser=appUserRepository.findByUserName(auth.getName());
//            room.setAppUser(appUser);
//            roomRepository.save(room);
//            appUser.getRooms().add(room);
//        }
//        catch (IOException e){
//            e.printStackTrace();

//
//            return "redirect:/add";
//        }

//        AppUser appUser=((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();

        return "redirect:/";
    }
//
//    @RequestMapping("/listmyrooms")
//    public String ListMyRooms(Model model, Authentication auth){
////        AppUser appUser=((CustomUserDetails)((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
//        AppUser appUser=appUserRepository.findByUserName(auth.getName());
//        model.addAttribute("myRooms",roomRepository.findAllByAppUser(appUser));
//
//
//        return "listmyrooms";
//    }
    @RequestMapping("/detail/{postId}")
    public String showMore(@PathVariable("postId") long postid, Model model){

        System.out.println(postid);
        model.addAttribute("post", postRepository.findById(postid).get());
        model.addAttribute("postedBy",postRepository.findById(postid).get().getPostedBy().getUserName());

        return "showmore";
    }

    @RequestMapping("/post/{userId}")
    public String profile(@PathVariable("userId") long userId, Model model){

        model.addAttribute("appUser", postRepository.findById(userId).get());


        return "profile";
    }

    //    @RequestMapping("/user/update/{roomId}")
//    public String updateUser(@PathVariable("roomId") long roomId, Model model){
//
//
//        model.addAttribute("room", roomRepository.findById(roomId).get());
//
//        return "roomform";
//    }
//    @RequestMapping("/admin/update/{roomId}")
//    public String updateAdmin(@PathVariable("roomId") long roomId, Model model){
//
//
//        model.addAttribute("room", roomRepository.findById(roomId).get());
//
//        return "roomform";
//    }

}
