# Movies API
An API for retrieving movie data along with comments on each movie

## Requirements
In order to run the API locally, you'll need the following installed on your machine:

- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [MongoDB](https://www.mongodb.com)

## Getting started

1. Ensure that MongoDB is up and running by using the command `sudo mongod`.
2. Import data from the file `movies.json` into a database called `movies` with a collection also called `movies`.
3. The application can then be started using the command `mvn spring-boot:run`.
4. The application will be listening for requests on port `8080`.

## Available requests

The following requests can be made via `Postman`:

- Retrieve a list of all movies: `localhost:8080/movies`.
- Retrieve the username with the most comments across all movies: `localhost:8080/movies/most-comments`
- Retrieve the movie with the most likes: `localhost:8080/movies/most-comments`

## Notes

- The application will not run correctly unless the data has been imported into MongoDB.
- All requests mentioned above are GET requests.
