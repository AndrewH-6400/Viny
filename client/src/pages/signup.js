import React from "react";
import Navbar from "../components/navbar";
import RegForm from "../components/loginregister/regForm";

function SignUp() {
    return (
        <div className="bg-indigo-950 h-lvh w-lvw px-7 pt-5">
            <div className="h-full w-full flex flex-col">
                <Navbar />
                <div className="h-full w-full flex flex-row text-slate-200 pb-4 p-2">
                    <div className="bg-indigo-900 p-1 h-full basis-1/2 overflow-auto rounded-md mx-auto">
                        <RegForm />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default SignUp;
