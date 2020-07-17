package com.dinhphu.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServices<T> {
    public List<T> findAll();
    public T findById(Integer id);
    public T update(T model);
    public T deleteModel(Integer id);
}
