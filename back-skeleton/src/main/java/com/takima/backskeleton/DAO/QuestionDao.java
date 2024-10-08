package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Categorie;
import com.takima.backskeleton.models.Choix;
import com.takima.backskeleton.models.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long> {

}
