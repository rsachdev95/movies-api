package rsachdev95.moviesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rsachdev95.moviesapi.model.clientmodel.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
