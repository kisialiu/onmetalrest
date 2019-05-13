package hello.repo;

import hello.model.Band;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BandRepository extends MongoRepository<Band, String> {

    Band findByBandNameIgnoreCase(String bandName);

    @Query("{ 'bandName' : { $regex : ?0, $options: 'i' } }")
    List<Band> findByBandNameRegex(String bandName);

    @Query("{ 'details.genre' : { $regex : ?0, $options: 'i' } }")
    List<Band> findByBandGenreRegex(String genre);

}
