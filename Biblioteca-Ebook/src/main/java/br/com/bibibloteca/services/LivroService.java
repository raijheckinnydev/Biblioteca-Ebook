package br.com.bibibloteca.services;

import br.com.bibibloteca.domain.Livro;
import br.com.bibibloteca.repository.ILivroReposity;
import com.cloudinary.utils.ObjectUtils;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class LivroService implements ILivroService {

    @Autowired
    private ILivroReposity reposity;

    @Override
    public void cadastrar(Livro livro) {
        livro.setDataLancamento(LocalDate.now());
        reposity.save(livro);
    }

    @Override
    public Livro buscarPorId(Long id) {
        return reposity.findById(id).get();
    }

    @Override
    public void alterar(Livro livro) {
        reposity.save(livro);
    }

    @Override
    public void remover(Long id) {
        reposity.deleteById(id);
    }

    @Override
    public List<Livro> buscarTodos() {
        return reposity.findAll();
    }
}
