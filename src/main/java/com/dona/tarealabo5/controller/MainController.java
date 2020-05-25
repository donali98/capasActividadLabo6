package com.dona.tarealabo5.controller;

import java.util.List;

import javax.validation.Valid;

import com.dona.tarealabo5.domain.Estudiante;
import com.dona.tarealabo5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/estudiante")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try {
            students = studentService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }

    @PostMapping(value = "/mostrarEstudiante")
    public ModelAndView findOne(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        Estudiante student = null;
        try {
            student = studentService.findOne(id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        mav.addObject("student", student);
        mav.setViewName("estudiante");

        return mav;
    }

    @PostMapping(value="/save")    
    public ModelAndView guardar(@Valid @ModelAttribute("student") Estudiante student, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            System.out.println("si");
            mav.setViewName("agregarEstudiante");
            mav.addObject("student", student);
        }
        else {
            studentService.save(student);
            List<Estudiante> students = null;
            try{
                students = studentService.findAll();
            }catch(Exception e){
                e.printStackTrace();
            }
            mav.addObject("students", students);
            mav.setViewName("listaEstudiantes");
        }
        return mav;
    }

    @PostMapping(value = "/borrarEstudiante")
    public ModelAndView delete(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try{
            studentService.delete(id);
            students = studentService.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }
    
    @GetMapping("/insertarEstudiante")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", new Estudiante());
        mav.setViewName("agregarEstudiante");
        return mav;
    }
}