import React, { useEffect, useState } from "react";
import DisAlbum from "./disAlbum";

function Display() {
    const [album, setAlbum] = useState({
        ID: 0,
        Title: "N/A",
        Artist: "N/A",
        Art: "N/A",
    });
    const [albumList, setAlbumList] = useState([
        {
            ID: 1,
            Title: "Echoes",
            Artist: "The Rapture",
            Art: "https://upload.wikimedia.org/wikipedia/en/9/94/Rapture_echoes.jpg",
        },
        {
            ID: 2,
            Title: "Crawler",
            Artist: "Idles",
            Art: "https://upload.wikimedia.org/wikipedia/en/e/e8/Crawler_Idles.jpg",
        },
        {
            ID: 3,
            Title: "When The Pawn...",
            Artist: "Fiona Apple",
            Art: "https://upload.wikimedia.org/wikipedia/en/2/24/Fiona_apple_when_the_pawn.jpg",
        },
        {
            ID: 4,
            Title: "People Who Can Eat People Are the Luckiest People in the World",
            Artist: "AJJ",
            Art: "https://upload.wikimedia.org/wikipedia/en/e/e9/AJJ_People_That_Can_Eat_People.jpg",
        },
    ]);

    useEffect(() => {
        console.log(albumList);
    }, []);

    return (
        <div>
            Display
            {albumList.map((al) => (
                <DisAlbum
                    key={al.ID}
                    title={al.Title}
                    artist={al.Artist}
                    art={al.Art}
                />
            ))}
        </div>
    );
}

export default Display;
