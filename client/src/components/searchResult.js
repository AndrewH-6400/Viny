import React from "react";

function SearchResult(props) {
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
        </div>
    );
}

export default SearchResult;
