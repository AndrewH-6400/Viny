import React from "react";
import LoginForm from "../components/loginregister/loginForm";
import Navbar from "../components/navbar";

function Login() {
    return (
        <div className="bg-indigo-950 h-lvh w-lvw px-7 pt-5">
            <div className="h-full w-full flex flex-col">
                <Navbar />
                <div className="h-full w-full flex flex-row text-slate-200 pb-4 p-2">
                    <div className="bg-indigo-900 p-1 h-full basis-1/2 overflow-auto rounded-md mx-auto">
                        <LoginForm />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
