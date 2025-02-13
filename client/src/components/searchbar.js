import React, { useEffect, useState } from "react";
import SearchResult from "./searchResult";

function Searchbar() {
    const [search, setSearch] = useState("");
    const [results, setResults] = useState();

    useEffect(() => {
        if (search !== undefined && search !== "") {
            fetch("http://localhost:8080/search/al?search=" + search)
                .then((response) => response.json())
                .then((data) => {
                    console.log(data);
                    setResults(data);
                });
        }
    }, [search]);

    return (
        <div className="mx-auto ">
            <form>
                <input
                    type="text"
                    className="text-black rounded-md"
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                />
            </form>
            {results !== undefined && (
                <div className="bg-white absolute w-fit h-fit">
                    {results.map((al) => (
                        <SearchResult
                            key={al.id}
                            id={al.id}
                            title={al.title}
                            artist={al.artistName}
                            art={al.images[1]}
                        />
                    ))}
                </div>
            )}
        </div>
    );
}

export default Searchbar;
