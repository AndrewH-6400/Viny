import React, { useEffect } from "react";

function Guide() {
    /*
    returns an array of the album search results to be sorted
    url is to the local server which will handle the call to spotify api and format the data (mostly)
    information I want to be handled here is :Limit(number of results), offset(information for displaying multiple pages very important for search)
    ,search parameter
    eventually possibly the type as well (album vs song/nothing)
    */
    useEffect(() => {
        // fetch("http://localhost:8080/search/al")
        //     .then((response) => response.json())
        //     .then((data) => console.log(data.albums.items));
    }, []);

    return (
        <div>
            <div>Guide</div>
            <div>{/*>Collections</a> */}</div>
        </div>
    );
}

export default Guide;
