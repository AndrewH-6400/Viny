import React from "react";

function SearchResult(props) {
    const handleClick = (e) => {
        fetch(
            "http://localhost:8080/sc/addToMCollection?uId=1&aId=" + props.id,
            {
                method: "POST",
            }
        ).then((response) => console.log(response));
    };
    return (
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
