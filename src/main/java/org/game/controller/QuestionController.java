package org.game.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.game.db.dao.QuestionDao;
import org.game.db.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class QuestionController {
 
    @Autowired
    private QuestionDao questDao;
 
    @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String value = request.getParameter("name");
        if (value != null)
            questDao.persist(new Question(value));
 
        return new ModelAndView("guest", "questDao", questDao);
    }
}