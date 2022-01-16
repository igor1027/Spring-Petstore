package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.entity.Category;
import com.example.spring_boot_rest.entity.Pet;
import com.example.spring_boot_rest.repository.CategoryRepository;
import com.example.spring_boot_rest.repository.PetRepository;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;

public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public boolean save(Pet pet){
        if (petRepository.existsById(pet.getId())){
            throw new RuntimeException();
        }
    }

    private void petFilling(Pet pet){

    }

}
