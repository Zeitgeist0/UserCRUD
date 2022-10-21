package com.usercrud.service;

import java.util.List;
import java.util.Optional;

public interface Service <T> {
    Optional<T> findById(Integer id);
    List<T> findAll();

    void save(T obj);

    void delete(T obj);

    void deleteById(Integer id);



}