package org.game.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.game.db.dao.QuestionDao;
import org.game.db.domain.Answer;
import org.game.db.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private QuestionDao questDao;
 
    @RequestMapping(value="/admin")
    public ModelAndView admin(HttpServletRequest request) {
        return new ModelAndView("admin");
    }
    
    @RequestMapping(value="/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(HttpServletRequest request) {
    	Question question = new Question();
    	question.setValue(request.getParameter("question"));
    	
    	List<Answer> answers = new ArrayList<Answer>();
    	answers.add(new Answer(question, request.getParameter("answer1"), 0l));
    	answers.add(new Answer(question, request.getParameter("answer2"), 0l));
    	answers.add(new Answer(question, request.getParameter("answer3"), 0l));
    	answers.add(new Answer(question, request.getParameter("answer4"), 0l));

    	question.setAnswers(answers);
    	
    	questDao.persist(question);
    	
        return new ModelAndView("admin");
    }
    
    @RequestMapping(value = "/getQuestions")
    public @ResponseBody String getQuestions() {
        return questDao.getAllQuests().toString();//FIXME this should not return toString. return JSON instead.
    }
    
    
//    @RequestMapping(value = "/getQuestions")
//    public @ResponseBody List<Question> getQuestions() {
//    	return questDao.getAllQuests();
//    	//FIXME this should not return toString. return JSON instead.
//    }
	
}
