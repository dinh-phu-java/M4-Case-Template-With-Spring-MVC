package com.dinhphu.services.image;

import com.dinhphu.model.Image;
import com.dinhphu.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices implements IImageServices{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(Integer id) {
        return imageRepository.findOne(id);
    }

    @Override
    public Image update(Image model) {
        return imageRepository.save(model);
    }

    @Override
    public Image deleteModel(Integer id) {
        Image deleteImage=imageRepository.findOne(id);
        imageRepository.delete(id);
        return deleteImage;
    }
}
