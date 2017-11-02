package io.github.jimmyrengga.explorespring.repository;

import io.github.jimmyrengga.explorespring.entity.JenisKelamin;
import io.github.jimmyrengga.explorespring.entity.Orang;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.ExampleMatcher;

/**
 *
 * @author jimmy.saputro
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class OrangRepositoryTests {
    // ** Uncomment the 2 below lines if you want to use EntityManager
    // @Autowired
    // private TestEntityManager entityManager;
    
    @Autowired
    private OrangRepository orangRepository;
    
    @Test
    public void testOrang() {
        Orang orang = new Orang();
        orang.setNama("Jimmy Rengga");
        orang.setJenisKelamin(JenisKelamin.PRIA);
        orang.setUmur(25);
        
        orangRepository.save(orang);
        // ** uncomment the below lines if you want to use EntityManager
        // entityManager.persist(orang);
        
        // test menggunakan simple example
        Orang or = new Orang();
        or.setNama("Jimmy Rengga");
        Example<Orang> exOrang1 = Example.of(or);
        Orang orang1 = orangRepository.findOne(exOrang1);
        assertThat(orang1.getUmur()).isEqualTo(25);
        System.out.println("\n~> Orang1 : " + orang1);
        
        // test menggunakan ExampleMather
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("jimmy RENGGA");
        Example<Orang> exOrang2 = Example.of(or, matcher);
        Orang orang2 = orangRepository.findOne(exOrang2);
        assertThat(orang2.getJenisKelamin()).isNotEqualByComparingTo(JenisKelamin.WANITA);
        System.out.println("\n~> Orang2 : " + orang2);
    }
    
}
