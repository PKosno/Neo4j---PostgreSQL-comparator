package project.app.modelGraph;

import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Relationship(type = "Directors", direction = Relationship.INCOMING)
    private List<Directors> directors;
    @Relationship(type = "language", direction = Relationship.INCOMING)
    private Languages language;
    @Relationship(type = "reviews", direction = Relationship.INCOMING)
    private List<Reviews> reviews;
    @Relationship(type = "genres", direction = Relationship.INCOMING)
    private List<Genre> genres;
    @Relationship(type = "tags", direction = Relationship.INCOMING)
    private List<Tags> tags;
    @Relationship(type = "actors", direction = Relationship.INCOMING)
    private List<Actors> actors;
    @Relationship(type = "awards", direction = Relationship.INCOMING)
    private List<Awards> awards;
    private String country;
    private String releaseDate;
    private int movieLength;

    public Movie() {
    }

    public Movie(Long id, String title, List<Directors> directors, Languages language, List<Reviews> reviews, List<Genre> genres, List<Tags> tags, List<Actors> actors, List<Awards> awards, String country, String releaseDate, int movieLength) {
        this.id = id;
        this.title = title;
        this.directors = directors;
        this.language = language;
        this.reviews = reviews;
        this.genres = genres;
        this.tags = tags;
        this.actors = actors;
        this.awards = awards;
        this.country = country;
        this.releaseDate = releaseDate;
        this.movieLength = movieLength;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }
}
