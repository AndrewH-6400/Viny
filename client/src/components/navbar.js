import React from "react";
import icon from "../images/favicon-32x32.png";
import Searchbar from "./searchbar";

function Navbar() {
    return (
        <div className="text-slate-200 flex flex-row pb-2 ">
            <div className="flex-initial w-fit flex">
                <img src={icon} alt="icon" className="inline mx-2" />
                <span className="italic text-3xl align-middle">Viny</span>
            </div>

            <Searchbar />

            <div className="justify-end flex flex-row">
                <a className="mx-2" href="/login">
                    Login
                </a>
                <a className="mx-2" href="/register">
                    Register
                </a>
            </div>
        </div>
    );
}

export default Navbar;
