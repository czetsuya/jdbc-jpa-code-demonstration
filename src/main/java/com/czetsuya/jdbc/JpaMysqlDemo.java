package com.czetsuya.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.czetsuya.jdbc.model.Product;
import com.czetsuya.jdbc.persistence.PersistenceManager;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class JpaMysqlDemo {

    public static void main(String args[]) {
        new JpaMysqlDemo();
    }

    public JpaMysqlDemo() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        jdbcTest(em);

        PersistenceManager.INSTANCE.close();
    }

    private void jdbcTest(EntityManager em) {
        testFetchAll(em);

        testInsert(em);
        testFetchAll(em);
        testUpdate(em);
        testFetchAll(em);
        testDelete(em);
        testFetchAll(em);
    }

    private void testDelete(EntityManager em) {

        System.out.println("\nDelete IPHONE11 in product");
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Product p WHERE p.disabled=false AND p.code='IPHONE11'");
        Product product = (Product) query.getSingleResult();
        em.remove(product);

        em.getTransaction().commit();
    }

    private void testUpdate(EntityManager em) {

        System.out.println("\nUpdate data in product");
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Product p WHERE p.disabled=false AND p.code='IPHONE11'");
        Product product = (Product) query.getSingleResult();
        product.setDescription(
                "Meet iPhone 11. All-new dual-camera system with Ultra Wide and Night mode. All-day battery. Six new colors. And the A13 Bionic, our fastest chip ever.");
        em.merge(product);

        em.getTransaction().commit();
    }

    private void testInsert(EntityManager em) {

        System.out.println("\nInsert data into product");
        em.getTransaction().begin();

        Product product = new Product();
        product.setCode("IPHONE11");
        product.setDescription("iPhone11 v1");
        product.setAmount(new BigDecimal(70000));
        product.setCreatedAt(LocalDate.now());

        // saves the entity
        em.persist(product);

        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    private void testFetchAll(EntityManager em) {

        System.out.println("\nFetch product from database");
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Product p WHERE p.disabled=false");
        List<Product> products = (List<Product>) query.getResultList();
        products.forEach(e -> System.out.println(e));

        em.getTransaction().commit();
    }
}
