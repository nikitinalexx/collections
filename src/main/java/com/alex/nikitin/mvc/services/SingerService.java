package com.alex.nikitin.mvc.services;


import com.alex.nikitin.mvc.entities.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

    Singer findByFirstNameAndLastName(String firstName, String lastName);

}
