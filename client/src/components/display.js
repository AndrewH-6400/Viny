import React, { useEffect, useState } from "react";
import DisAlbum from "./disAlbum";

function Display() {
    const [album, setAlbum] = useState();
    const [albumid, setAlbumID] = useState();

    const [albumList, setAlbumList] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/sc/getById?id=1")
            .then((response) => response.json())
            .then((data) => setAlbumID(data[1]));
    }, []);
    useEffect(() => {
        if (albumid !== undefined) {
            fetch("http://localhost:8080/search/alid?id=" + albumid)
                .then((response) => response.json())
                .then((data) => {
                    console.log(data.images[1].url);
                    setAlbum(data);
                });
        }
    }, [albumid]);

    useEffect(() => {
        fetch("http://localhost:8080/sc/getMByUserId?uId=1")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                setAlbumList(data.albums);
            });
    }, []);

    return (
        <div>
            Display(Collection Name)
            <div className="flex flex-row flex-wrap">
                {/* mapping will be used later */}
                {/* {
                    albumList !== undefined &&
                    albumList.map((al) => (
                    <DisAlbum
                        key={al.ID}
                        title={al.Title}
                        artist={al.Artist}
                        art={al.Art}
                    />
                ))} */}
                {album !== undefined && (
                    <DisAlbum
                        title={album.name}
                        artist={album.artists[0].name}
                        art={album.images[1].url}
                    />
                )}
            </div>
        </div>
    );
}

export default Display;
