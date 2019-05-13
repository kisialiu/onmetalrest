package hello.repo;

import hello.model.FullAlbum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlbumRepository extends MongoRepository<FullAlbum, String> {

    @Query("{ 'title' : { $regex : ?0, $options: 'i' } }")
    List<FullAlbum> findByTitleRegex(String title);


    @Query("{ 'title' : { $regex : ?0, $options: 'i' } }")
    List<FullAlbum> findLatest(String title);

    @Query("{ 'release date' : {'$date': '?0'} }")
    List<FullAlbum> findToday(String date);
}
