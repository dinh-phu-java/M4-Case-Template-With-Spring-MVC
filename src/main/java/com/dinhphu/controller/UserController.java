package com.dinhphu.controller;

import com.dinhphu.dto.UserDTO;
import com.dinhphu.model.User;
import com.dinhphu.services.role.IRoleServices;
import com.dinhphu.services.user.IUserServices;
import com.dinhphu.utils.DateUtils;
import com.dinhphu.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserServices userServices;

    @Autowired
    private IRoleServices roleServices;

    @Autowired
    private Environment environment;

    @GetMapping("")
    public ModelAndView userList(){
        ModelAndView modelAndView=new ModelAndView("users/list-user");
        List<User> users= new ArrayList<>(userServices.findAll());
        Date date=null;
        for (int i=0;i< users.size();i++){

            date = DateUtils.strToDate(users.get(i).getDateOfBirth());
            String dateFormatStr= DateUtils.dateToString(date);
            users.get(i).setDateOfBirth(dateFormatStr);
        }

        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createUserForm(){
        ModelAndView modelAndView =new ModelAndView("users/create-user");
        modelAndView.addObject("userDTO",new UserDTO());
        modelAndView.addObject("roles",roleServices.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    @ResponseBody
    public String createUserProcess(@ModelAttribute UserDTO userDTO){

        MultipartFile file=userDTO.getFile();
        String imageName=file.getOriginalFilename();
        User newUser = new User();
        newUser= UserUtils.setUserFromUserDTO(userDTO,imageName,roleServices.findById(1));
        System.out.println(newUser);
        String uploadFileTarget=environment.getProperty("file_upload");
        String message="";


//        System.out.println("upload file target: "+uploadFileTarget);
//        System.out.println("user DTO: "+userDTO);
//        System.out.println("new USer: "+newUser);

        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") ){
            try{
                FileCopyUtils.copy(file.getBytes(),new File(uploadFileTarget+imageName));
            }catch(Exception e){
                e.printStackTrace();
            }
            userServices.update(newUser);

            message="Create new User: "+newUser.getName()+" Successful!";

        }else{
            message="file should type be image and file size less than 5MB";
        }

        return message;
    }
}
