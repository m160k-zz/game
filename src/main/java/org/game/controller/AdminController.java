package org.game.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

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
    	
    	//TODO Task #1. use request.getParameter("question") to get the correct answer index
    	//implement logic to set the appropriate answer's isCorrect field to TRUE
    	
    	 //String q2 = request.getParameter("2");
    	// String q3 = request.getParameter("3");
    	// String q4 = request.getParameter("4");
    	
    	List<Answer> answers = new ArrayList<Answer>();
//    	answers.add(new Answer(question, request.getParameter("answer1"), 0l));
//    	answers.add(new Answer(question, request.getParameter("answer2"), 0l));
//    	answers.add(new Answer(question, request.getParameter("answer3"), 0l));
//    	answers.add(new Answer(question, request.getParameter("answer4"), 0l));
    	Answer answer1 = new Answer(question, request.getParameter("answer1"), 0l);
    	answers.add(answer1);
    	Answer answer2 = new Answer(question, request.getParameter("answer2"), 0l);
    	answers.add(answer2);
    	Answer answer3 = new Answer(question, request.getParameter("answer3"), 0l);
    	answers.add(answer3);
    	Answer answer4 = new Answer(question, request.getParameter("answer4"), 0l);
    	answers.add(answer4);
    		 String ans = request.getParameter("answer");
        	 if("1".equals(ans)) {
        		answer1.setIsCorrect(1l);
        	 } if("2".equals(ans)) {
         		answer2.setIsCorrect(1l);
         	 } if("3".equals(ans)) {
          		answer3.setIsCorrect(1l);
          	 } if("4".equals(ans)) {
          		answer4.setIsCorrect(1l);
          	 } if(("1" != ans) && ("2" != ans) && ("3" != ans) && ("4" != ans))
 

    	question.setAnswers(answers);
    	
    	questDao.persist(question);
    	
        return new ModelAndView("admin");
    }
    
    @RequestMapping(value = "/getQuestions")
    public @ResponseBody List<Question> getQuestions() {
    	return questDao.getAllQuests();
    	//FIXME this should not return toString. return JSON instead.
    }
    
    
//    @RequestMapping(value = "/getQuestions")
//    public @ResponseBody List<Question> getQuestions() {
//    	return questDao.getAllQuests();
//    	//FIXME this should not return toString. return JSON instead.
//    }
	
}
