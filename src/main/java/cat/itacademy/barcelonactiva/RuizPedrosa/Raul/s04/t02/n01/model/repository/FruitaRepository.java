package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t02.n01.model.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
}