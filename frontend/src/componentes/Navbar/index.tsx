import { ReactComponent as GitHubIcon } from 'recursos/img/Vector.svg'
import './styles.css';

function Navbar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://github.com/irlansuzano">
                        <div className="dsmovie-gitIcon-nome" >
                            <GitHubIcon />
                            <p className="dsmovie-contact-link">/irlansuzano</p>
                        </div>
                    </a>
                </div>

            </nav>
        </header>
    );
}

export default Navbar;