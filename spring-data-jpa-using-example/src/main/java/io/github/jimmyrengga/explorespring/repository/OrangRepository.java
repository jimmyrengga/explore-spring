package io.github.jimmyrengga.explorespring.repository;

import io.github.jimmyrengga.explorespring.entity.Orang;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 *
 * @author jimmy.saputro
 */
public interface OrangRepository extends PagingAndSortingRepository<Orang, String>, QueryByExampleExecutor<Orang>{
    
    
    
}
