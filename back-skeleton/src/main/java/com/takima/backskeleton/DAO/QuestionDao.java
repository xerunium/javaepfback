package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDao extends CrudRepository<Question, Long> {
}
