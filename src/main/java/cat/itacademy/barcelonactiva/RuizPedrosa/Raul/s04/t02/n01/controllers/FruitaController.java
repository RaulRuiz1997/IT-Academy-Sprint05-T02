package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.services.FruitaInterface;
import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    FruitaInterface fruitaService;

    // http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruita> afegirFruita(@RequestBody Fruita fruita) {
        return fruitaService.afegirFruita(fruita);
    }

    // http://localhost:8080/fruita/update
    // Método para todos los campos
    @PutMapping("/update")
    public ResponseEntity<Fruita> modificarFruita(@RequestBody Fruita fruita) {
        return fruitaService.modificarFruita(fruita);
    }

    // http://localhost:8080/fruita/update
    // Método para cambiar 1 o mas de 1 campo
    @PatchMapping("/update")
    public ResponseEntity<Fruita> actualitzarFruita(@RequestBody Fruita fruita) {
        return fruitaService.actualitzarFruita(fruita);
    }

    // http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruita> borrarFruita(@PathVariable Integer id) {
        return fruitaService.borrarFruita(id);
    }

    // http://localhost:8080/fruita/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> trobarFruitaPerId(@PathVariable Integer id) {
        return new ResponseEntity<>(fruitaService.trobarFruitaPerId(id), HttpStatus.OK);
    }

    // http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> trobarTotesFruites() {
        return new ResponseEntity<>(fruitaService.trobarTotesFruites(), HttpStatus.OK);
    }

}
