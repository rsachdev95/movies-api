package rsachdev95.moviesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rsachdev95.moviesapi.model.clientmodel.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
