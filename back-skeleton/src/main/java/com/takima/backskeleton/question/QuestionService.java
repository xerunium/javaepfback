package com.takima.backskeleton.question;

import com.takima.backskeleton.choix.ChoixDao;
import com.takima.backskeleton.choix.Choix;
import com.takima.backskeleton.contenir.Contenir;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    QuestionDao questionDao;
    ChoixDao choixDao;
    public QuestionService(QuestionDao questionDao, ChoixDao choixDao) {
        this.questionDao = questionDao;
        this.choixDao = choixDao;
    }

    public Question save(Question question) {
        return questionDao.save(question);
    }

    public List<Question> generateQuestions(Integer nbquestions, Integer nbrChoix){
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < nbquestions; i++) {
            questions.add(generateQuestion(nbrChoix));
        }
        return questions;
    }

    public Question generateQuestion(int nbrChoix){
        long totalChoix = choixDao.count();
        int idChoixCorrect = randomChoix((int) totalChoix);
        Optional<Choix> choixCorrect = choixDao.findById((long) idChoixCorrect);
        return createQuestion(nbrChoix, choixCorrect);
    }

    public Question createQuestion(int nbrChoix, Optional<Choix> choixCorrect) {
        if(choixCorrect.isPresent()) {
            Choix choix = choixCorrect.get();

            // 1. Créer la question d'abord sans ses propositions (sans Contenir)
            Question question = new Question();
            question.setNb_choix(nbrChoix);
            Question savedQuestion = questionDao.save(question);

            // 2. Générer les choix incorrects
            List<Choix> choixIncorrects = choixDao.findIncorrectChoixByCategorie(choix.getCategorie(), choix.getId(), nbrChoix - 1);
            List<Contenir> contenirs = new ArrayList<>();

            for (int i = 0; i < nbrChoix - 1; i++) { // -1 car un des choix est correct
                Contenir contIncorrect = new Contenir(choixIncorrects.get(i), savedQuestion, false);
                contenirs.add(contIncorrect);
            }

            // 3. Ajouter le choix correct
            Contenir contCorrect = new Contenir(choix, savedQuestion, true);
            contenirs.add(contCorrect);
            Collections.shuffle(contenirs);

            // 4. Associer les contenirs à la question
            savedQuestion.setContenirs(contenirs);

            // 5. Sauvegarder les Contenir en cascade avec la question
            return questionDao.save(savedQuestion);
        }
        return null;
    }

    public int randomChoix(int n){
        Random random = new Random();
        return 1 + random.nextInt((int)n-1);
    }
}
