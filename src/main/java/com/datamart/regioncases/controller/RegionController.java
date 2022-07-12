package com.datamart.regioncases.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datamart.regioncases.entity.Region;
import com.datamart.regioncases.service.RegionService;

@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/form/region-register")
    public ModelAndView getRegister() {
        ModelAndView mv = new ModelAndView("regionRegister");
        return mv;
    }

    @RequestMapping(value = "/form/region/save", method = RequestMethod.POST)
    public ResponseEntity<String> Post(@Valid @RequestBody Region region) {
        try {
            this.regionService.save(region);
            return new ResponseEntity<String>("Cadastrado com sucesso", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao salvar", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/save")
    public String saveEdit(@Valid Region region, BindingResult result, RedirectAttributes redirect) {

        this.regionService.save(region);
        return "redirect:/list/region";
    }

    @RequestMapping(value = "/list/region", method = RequestMethod.GET)
    public ResponseEntity<List<Region>> Get() {
        return new ResponseEntity<List<Region>>(regionService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/region/{id}")
    public ResponseEntity<String> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Region oldRegion) {
        try {
            regionService.save(oldRegion);
            return new ResponseEntity<String>("Editado com sucesso", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "/delete/region/{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id") Long id) {
        try {
            this.regionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}