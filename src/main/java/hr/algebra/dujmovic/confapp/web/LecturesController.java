/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dujmovic.confapp.web;

import hr.algebra.dujmovic.confapp.data.LectureRepository;
import hr.algebra.dujmovic.confapp.model.Lecture;
import hr.algebra.dujmovic.confapp.model.Speaker;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author matij
 */
@Controller
@RequestMapping("/lectures")
@SessionAttributes({"types", "positions"})
public class LecturesController {

    private final LectureRepository lectureRepository;

    @Autowired
    public LecturesController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @GetMapping("/new")
    public String showForm(Model model) {
//        List<Lecture> lectureList = lectureRepository.findByTitle("Dinamo");
        
        
        model.addAttribute("lecture", new Lecture());
        model.addAttribute("types", Lecture.Type.values());
        model.addAttribute("positions", Speaker.Position.values());

        return "lectureProposal";
    }

    @PostMapping("new")
    public String processForm(@Valid @ModelAttribute Lecture lecture, Errors errors) {
        if (errors.hasErrors()) {
//            log.info("Predavanje ima grešaka. Prekida se slanje.");
            return "lectureProposal";
        }

        lectureRepository.save(lecture);
        
        return "lectureAccepted";
    }
    
}
