import React, { useEffect, useState } from "react";
import DisAlbum from "./disAlbum";

function Display() {
    const [album, setAlbum] = useState();
    const [albumid, setAlbumID] = useState();
    // const [albumList, setAlbumList] = useState([
    //     {
    //         ID: 1,
    //         Title: "Echoes",
    //         Artist: "The Rapture",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/9/94/Rapture_echoes.jpg",
    //     },
    //     {
    //         ID: 2,
    //         Title: "Crawler",
    //         Artist: "Idles",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/e/e8/Crawler_Idles.jpg",
    //     },
    //     {
    //         ID: 3,
    //         Title: "When The Pawn...",
    //         Artist: "Fiona Apple",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/2/24/Fiona_apple_when_the_pawn.jpg",
    //     },
    //     {
    //         ID: 4,
    //         Title: "People Who Can Eat People Are the Luckiest People in the World",
    //         Artist: "AJJ",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/e/e9/AJJ_People_That_Can_Eat_People.jpg",
    //     },
    //     {
    //         ID: 5,
    //         Title: "Ants from Up There",
    //         Artist: "Black Country New Road",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/d/d7/Ants_from_Up_There_-_Black_Country%2C_New_Road.jpg",
    //     },
    //     {
    //         ID: 6,
    //         Title: "Laurel Hell",
    //         Artist: "Mitski",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/a/a8/Mitski_-_Laurel_Hell.png",
    //     },
    //     {
    //         ID: 7,
    //         Title: "Turn on the Bright Lights",
    //         Artist: "Interpol",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/6/68/Interpol_-_Turn_On_The_Bright_Lights.jpg",
    //     },
    //     {
    //         ID: 8,
    //         Title: "Arthur Verocai",
    //         Artist: "Arthur Verocai",
    //         Art: "https://upload.wikimedia.org/wikipedia/en/e/eb/Arthur_Verocai_%28album%29.jpg",
    //     },
    // ]);

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

    return (
        <div>
            Display(Collection Name)
            <div className="flex flex-row flex-wrap">
                {/* mapping will be used later
                {albumList.map((al) => (
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
