package com.example.spring_boot_rest.repository;

import com.example.spring_boot_rest.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
