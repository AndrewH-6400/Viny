import React from "react";
import icon from "../images/favicon-32x32.png";

function Navbar() {
    return (
        <div className="text-slate-200 flex flex-row pb-2 ">
            <div className="flex-initial w-fit flex">
                <img src={icon} alt="icon" className="inline mx-2" />
                <span className="italic text-3xl align-middle">Viny</span>
            </div>
            <div className="justify-end flex flex-row w-full">
                <a className="mx-2" href="/login">
                    login
                </a>
                <a className="mx-2" href="/register">
                    sign up
                </a>
            </div>
        </div>
    );
}

export default Navbar;
