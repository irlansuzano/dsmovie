import axios from "axios";
import MovieCard from "componentes/MovieCard";
import Pagination from "componentes/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {
    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=title`)
            .then(response => {
                const data = response.data as MoviePage;
                setPage(data);
            });
    }, [pageNumber])

    /*
    ele busca pelo axios na url indicada, com o pageNumber indicado e
    ele depende do pageNumber para buscar, toda vez que pageNumber 
    mudar, ele refaz essa parte
    */



    const handlePageChange =(newPageNumber: number) =>{
        setPageNumber(newPageNumber);
    }

    /*
    mapeia cada filme que vem da coleção content, fazendo uma div 
    pra cada um deles
    todo elemento renderizado em uma dinamica de coleção deve ter
    um atributo key 
    */
    return (
        <>
            <Pagination page ={page} onChange={handlePageChange} />

            <div className="container">
                <div className="row">
                    {page.content.map(movie => (
                        <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                            <MovieCard movie={movie} />
                        </div>
                    )
                    )}
                </div>
            </div>
        </>
    );
}
export default Listing;