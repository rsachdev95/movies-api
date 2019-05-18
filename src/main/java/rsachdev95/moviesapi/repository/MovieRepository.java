package rsachdev95.moviesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rsachdev95.moviesapi.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
