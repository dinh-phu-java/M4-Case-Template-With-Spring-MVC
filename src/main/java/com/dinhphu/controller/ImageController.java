package com.dinhphu.controller;

import com.dinhphu.dto.ImageDTO;
import com.dinhphu.model.Image;
import com.dinhphu.model.Product;
import com.dinhphu.services.image.IImageServices;

import com.dinhphu.services.product.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private IImageServices imageServices;

    @Autowired
    private Environment environment;

    @Autowired
    private IProductServices productServices;

    @GetMapping("/create")
    public ModelAndView showImageCreateForm(){
        ModelAndView modelAndView =new ModelAndView("image/create-image");
        modelAndView.addObject("imageDTO",new ImageDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createImage(@ModelAttribute ImageDTO imageDTO){
        List<MultipartFile> files=imageDTO.getMultiFiles();

        Product product= productServices.findById(1);
        String upload_file=environment.getProperty("file_upload");

        for (int i=0;i<files.size();i++){
            try {
                FileCopyUtils.copy(files.get(i).getBytes(), new File(upload_file + files.get(i).getOriginalFilename()));
                Image newImage= new Image(files.get(i).getOriginalFilename(),product);

                product.addImage(newImage);
                imageServices.update(newImage);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        product.getImage().forEach(k-> System.out.println("Product Image is: "+k));

        return null;
    }
}
