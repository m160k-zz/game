package org.game.controller;
 
import java.util.Collection;

import org.game.db.dao.QuestionDao;
import org.game.db.domain.Answer;
import org.game.db.domain.Question;
import org.game.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class QuestionController {
 
    @Autowired
    private QuestionDao questDao;
    
    @RequestMapping(value = "/randomQuestion")
    public @ResponseBody Question randomQuestion() {
  	  	return questDao.getRandomQuestion();
    }
    
    @RequestMapping(value = "/isCorrect", method = RequestMethod.GET)
    public @ResponseBody Boolean isCorrect(@RequestParam("questionId") Long questionId, 
    		@RequestParam("answerId") Long answerId) {
    	Long correct = 0l;
    	Question quest = questDao.getQuestion(questionId);
    	Collection<Answer> answers = quest.getAnswers();
    	for(Answer a : answers) {
    		if(a.getAnswerId().equals(answerId)) {
    			correct = a.getIsCorrect();
    		}
    	}
    	return GameUtil.LongToBool(correct);    	
    }   
}