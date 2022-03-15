/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.repositories.impl;

import com.tony.pojos.Category;
import com.tony.repositories.CategoryRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hyngu
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    @Transactional
    public List<Category> getCategories() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("From Category");
        return q.getResultList();
    }

}
