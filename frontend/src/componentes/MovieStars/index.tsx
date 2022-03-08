import { ReactComponent as StarFull } from 'recursos/img/fullStar.svg';
import { ReactComponent as StarHalf } from 'recursos/img/halfStar.svg';
import { ReactComponent as StarEmpty } from 'recursos/img/emptyStar.svg';
import './styles.css';
function MovieStars() {
    return (
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    );
}

export default MovieStars;
