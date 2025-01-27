import React from "react";

function DisAlbum(props) {
    return (
        <div className="my-4">
            <span>
                <img
                    src={props.art}
                    alt="album art"
                    className="w-20 h-20 inline ml-3 mr-5"
                />
            </span>
            <span className="mx-2">{props.title}</span>
            <span className="mx-2">{props.artist}</span>
        </div>
    );
}

export default DisAlbum;
