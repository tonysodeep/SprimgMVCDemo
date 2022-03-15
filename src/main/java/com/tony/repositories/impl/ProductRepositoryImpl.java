/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tony.repositories.impl;

import com.tony.pojos.Product;
import com.tony.repositories.ProductRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hyngu
 */
@Repository
@Transactional
@PropertySource("classpath:info.properties")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    private Environment env;

    @Override
    public List<Product> getProducts(String kw, int page) {
        Session session = this.sessionFactoryBean.getObject().openSession();
        System.out.println("kw db" + kw);
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q.where(p);
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        int pageSize = Integer.parseInt(env.getProperty("info.page_size"));
        //cong thuc paging
        int start = (page - 1) * pageSize;

        query.setMaxResults(pageSize);
        query.setFirstResult(start);

        return query.getResultList();

    }

    @Override
    public int countProducts() {
        Session session = this.sessionFactoryBean.getObject().openSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Product");
        Object re = q.getSingleResult();
        return Integer.parseInt(re.toString());
    }

    @Override
    public boolean addOrUpdateProduct(Product p) {
        Session session = this.sessionFactoryBean.getObject().openSession();
        try {
            session.save(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
