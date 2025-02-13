import React from "react";
import "./home.css";
import Navbar from "../components/navbar";
import Guide from "../components/guide";
import Display from "../components/display";

function Home() {
    return (
        <div className="bg-indigo-950 h-lvh w-lvw px-7 pt-5">
            <div className="h-full w-full flex flex-col">
                <Navbar />
                <div className="h-full w-full flex flex-row text-slate-200 pb-4 p-2">
                    <div className="bg-indigo-900 p-1 h-full basis-1/4 overflow-auto rounded-md">
                        <Guide />
                    </div>
                    <div className="bg-indigo-900 mx-2 p-1 h-full basis-3/4 overflow-auto rounded-md">
                        <Display />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;
