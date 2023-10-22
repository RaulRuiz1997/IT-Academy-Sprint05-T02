package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.domain.Fruita;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FruitaInterface {

    ResponseEntity<Fruita> afegirFruita(Fruita fruita);
    ResponseEntity<Fruita> modificarFruita(Fruita fruita);
    ResponseEntity<Fruita> actualitzarFruita(Fruita fruita);
    ResponseEntity<Fruita> borrarFruita(Integer id);
    Fruita trobarFruitaPerId(Integer id);
    List<Fruita> trobarTotesFruites();

}
