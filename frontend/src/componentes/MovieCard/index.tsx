import MovieScore from "componentes/MovieScore";
import { Link } from "react-router-dom";


function MovieCard() {

    const movie = {
        id: 1,
        image: "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
        title: "The Witcher",
        count: 2,
        score: 4.5
    };

    const movie1 = {
        id:2,
        image: "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1iVjKCGHPVNj7IQVB1DdpL8U7Y8.jpg",
        title: "A Era do Gelo: As Aventuras de Buck",
        count: 2,
        score: 4.5
    };


    return (
        <div>
            <img className="dsmovie-movie-card-image" src={movie.image} alt={movie.title} />
            <div className="dsmovie-card-bottom-container">
                <h3>{movie.title}</h3>
                <MovieScore />

                <Link to={`/form/${movie.id}`}> 
                    <div className="btn btn-primary dsmovie-btn">Avaliar</div>
                </Link>
            </div>
            <img className="dsmovie-movie-card-image" src={movie1.image} alt={movie1.title} />
            <div className="dsmovie-card-bottom-container">
                <h3>{movie1.title}</h3>
                <MovieScore />

                <Link to={`/form/${movie1.id}`}> 
                    <div className="btn btn-primary dsmovie-btn">Avaliar</div>
                </Link>
            </div>
        </div>

        
    );

}

export default MovieCard;