package br.com.bibibloteca.controller;

import br.com.bibibloteca.domain.Livro;
import br.com.bibibloteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/formulario")
    public String showFromBook(Model model) {
        model.addAttribute("livro", new Livro());
        return "formularioLivro";
    }

    @PostMapping("/save")
    public String saveSubmit(@ModelAttribute("livro") Livro livro, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            livro.setCapa(file.getBytes());
        }
        livroService.cadastrar(livro);
        return "redirect:/livro/formulario";
    }
    @GetMapping("/image/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable("id") Long id) {
        return livroService.buscarPorId(id).getCapa();
    }

    @GetMapping("/view-image/{id}")
    public ModelAndView viewImagePage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("view-image");
        mav.addObject("imageId", id);
        return mav;
    }
}
