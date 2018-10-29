package hh.swd2.ekaSpringProjekti.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {

    List<Survey> findByTitle(String title);
    
}