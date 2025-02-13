import React, { useEffect, useState } from "react";

function Searchbar() {
    const [search, setSearch] = useState("");

    useEffect(() => {
        if (search !== undefined && search !== "") {
            fetch("http://localhost:8080/search/al?search=" + search)
                .then((response) => response.json())
                .then((data) => console.log(data));
        }
    }, [search]);

    return (
        <form className="mx-auto ">
            <input
                type="text"
                className="text-black"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />
        </form>
    );
}

export default Searchbar;
