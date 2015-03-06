package org.game.controller;
 
import org.game.db.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
@Controller
public class QuestionController {
 
    @Autowired
    private QuestionDao questDao;
    
}