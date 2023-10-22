package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.Fruita;
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
    FruitaService fruitaService;

    // http://localhost:8080/fruita/add
    @PostMapping("/add")
    public Fruita afegirFruita(@RequestBody Fruita fruita) {
        return fruitaService.afegirFruita(fruita);
    }

    // http://localhost:8080/fruita/update
    // Método para todos los campos
    @PutMapping("/update")
    public void modificarFruita(@RequestBody Fruita fruita) {
        fruitaService.modificarFruita(fruita);
    }

    // http://localhost:8080/fruita/update
    // Método para cambiar 1 o mas de 1 campo
    @PatchMapping("/update")
    public void actualitzarFruita(@RequestBody Fruita fruita) {
        fruitaService.actualitzarFruita(fruita);
    }

    // http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void borrarFruita(@PathVariable Integer id) {
        fruitaService.borrarFruita(id);
    }

    // http://localhost:8080/fruita/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> trobarFruitaPerId(@PathVariable Integer id) {
        return new ResponseEntity<>(fruitaService.trobarFruitaPerId(id), HttpStatus.OK);
    }

    // http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public List<Fruita> trobarTotesFruites() {
        return fruitaService.trobarTotesFruites();
    }

}
