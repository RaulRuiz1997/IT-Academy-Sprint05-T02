package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FruitaService implements FruitaInterface {

    @Autowired
    FruitaRepository fruitaRepository;

    // POST
    @Override
    public ResponseEntity<Fruita> afegirFruita(Fruita fruita) {
        return new ResponseEntity<>(fruitaRepository.save(fruita), HttpStatus.OK);
    }

    // PUT
    @Override
    public ResponseEntity<Fruita> modificarFruita(Fruita fruita) {

        Fruita fruitaModificada = fruitaRepository.findById(fruita.getId()).get();

        fruitaModificada.setNom(fruita.getNom());
        fruitaModificada.setQuantitatQuilos(fruita.getQuantitatQuilos());

        return new ResponseEntity<>(fruitaRepository.save(fruitaModificada), HttpStatus.OK);

    }

    // PATCH
    @Override
    public ResponseEntity<Fruita> actualitzarFruita(Fruita fruita) {

        Fruita fruitaModificada = fruitaRepository.findById(fruita.getId()).get();

        if (fruita.getNom() != null || !fruita.getNom().isEmpty()) {
            fruitaModificada.setNom(fruita.getNom());
        }

        if (fruita.getQuantitatQuilos() > 0) {
            fruitaModificada.setQuantitatQuilos(fruita.getQuantitatQuilos());
        }

        return new ResponseEntity<>(fruitaRepository.save(fruitaModificada), HttpStatus.OK);

    }

    // DELETE
    @Override
    public ResponseEntity<Fruita> borrarFruita(Integer id) {

        Fruita fruitaBorrada = null;

        if (fruitaRepository.findById(id).isPresent()) {
            fruitaBorrada = fruitaRepository.findById(id).get();
        }

        fruitaRepository.deleteById(id);

        return new ResponseEntity<>(fruitaBorrada, HttpStatus.OK);

    }

    // GET
    @Override
    public Fruita trobarFruitaPerId(Integer id) {

        if (fruitaRepository.findById(id).isPresent()) {

            return fruitaRepository.findById(id).get();

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID no encontrado");

        }

    }

    // GET
    @Override
    public List<Fruita> trobarTotesFruites() {
        return fruitaRepository.findAll();
    }

}
