import React from "react";

function DisAlbum(props) {
    return (
        <div className="my-4 px-4 basis-1/8">
            <span>
                <img
                    src={props.art}
                    alt={props.title}
                    className="w-20 h-20 mx-auto"
                />
            </span>
            {/* <span className="mx-2">{props.title}</span>
            <span className="mx-2">{props.artist}</span> */}
        </div>
    );
}

export default DisAlbum;
