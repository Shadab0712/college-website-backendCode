package com.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.website.model.News;

public interface NewsRepository extends CrudRepository<News,Long>{

}
