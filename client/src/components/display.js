import React, { useEffect, useState } from "react";
import DisAlbum from "./disAlbum";

function Display() {
    const [albumList, setAlbumList] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/search/umcbuid?uid=1")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setAlbumList(data);
            });
    }, []);

    return (
        <div>
            Display(Collection Name)
            <div className="flex flex-row flex-wrap">
                {albumList !== undefined &&
                    albumList.map((al) => (
                        <DisAlbum
                            key={al.id}
                            title={al.title}
                            artist={al.artistName}
                            art={al.images[1]}
                        />
                    ))}
                {/* {album !== undefined && (
                    <DisAlbum
                        title={album.name}
                        artist={album.artists[0].name}
                        art={album.images[1].url}
                    />
                )} */}
            </div>
        </div>
    );
}

export default Display;
