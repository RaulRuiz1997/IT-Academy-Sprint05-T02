package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.Fruita;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FruitaService {

    @Autowired
    FruitaRepository fruitaRepository;

    // POST
    public Fruita afegirFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    // PUT
    public void modificarFruita(Fruita fruita) {

        Fruita fruitaModificada = fruitaRepository.findById(fruita.getId()).get();

        fruitaModificada.setNom(fruita.getNom());
        fruitaModificada.setQuantitatQuilos(fruita.getQuantitatQuilos());

        fruitaRepository.save(fruitaModificada);

    }

    // PATCH
    public void actualitzarFruita(Fruita fruita) {

        Fruita fruitaModificada = fruitaRepository.findById(fruita.getId()).get();

        if (fruita.getNom() != null || !fruita.getNom().isEmpty()) {
            fruitaModificada.setNom(fruita.getNom());
        }

        if (fruita.getQuantitatQuilos() > 0) {
            fruitaModificada.setQuantitatQuilos(fruita.getQuantitatQuilos());
        }

        fruitaRepository.save(fruitaModificada);

    }

    // DELETE
    public void borrarFruita(Integer id) {
        fruitaRepository.deleteById(id);
    }

    // GET
    public Fruita trobarFruitaPerId(Integer id) {

        if (fruitaRepository.findById(id).isPresent()) {

            return fruitaRepository.findById(id).get();

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID no encontrado");

        }

    }

    // GET
    public List<Fruita> trobarTotesFruites() {
        return fruitaRepository.findAll();
    }

}
