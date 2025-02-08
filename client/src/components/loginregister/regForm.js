import React, { useState } from "react";

export default function RegForm() {
    const [formData, setFormData] = useState({});

    const [username, setUserName] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(formData);
        const data = {
            id: 0,
            username: formData.username,
            password: formData.password,
        };
        console.log(data);
        //issue where cors does not allow changing the content type to application/json
        fetch("http://localhost:8080/saveUser", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(data),
        }).then((result) => console.log(result));
        //alert(username);
    };

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setFormData((values) => ({ ...values, [name]: value }));
        //console.log(formData);
    };

    return (
        <div className="h-fit w-fit mx-auto my-8">
            <form onSubmit={handleSubmit} className="flex flex-col">
                <div className="h-fit w-fit my-2">
                    <label className="pr-1">Username:</label>
                    <input
                        className="text-black"
                        type="text"
                        name="username"
                        value={formData.username || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <div className="h-fit w-fit my-2">
                    <label className="pr-1">Password:</label>
                    <input
                        className="text-black"
                        type="password"
                        name="password"
                        value={formData.pswd}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <input type="submit" />
            </form>
        </div>
    );
}
