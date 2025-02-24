import React from "react";

function SearchResult(props) {
    //sends the album to be added to the users master library
    //more a proof of concept then a final implementation
    const handleClick = () => {
        fetch(
            "http://localhost:8080/sc/addToMCollection?uId=1&aId=" + props.id,
            {
                method: "POST",
            }
        ).then((response) => {
            window.location.reload(false);
            console.log(response);
        });
        //
    };
    return (
        //draws album and button
        <div className="text-black flex flex-row">
            <span>
                <img
                    src={props.art}
                    alt={props.title}
                    className="w-20 h-20 mx-auto"
                />
            </span>
            <div className="flex flex-col">
                <p>{props.title}</p>
                <p>{props.artist}</p>
            </div>
            <button
                type="button"
                className="w-fit h-fit bg-green-400"
                onClick={handleClick}
            >
                Add Album
            </button>
        </div>
    );
}

export default SearchResult;
