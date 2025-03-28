import React, { useEffect, useState } from "react";
import bcrypt from "bcryptjs";

function LoginForm() {
    const [formData, setFormData] = useState({});

    //format and submit the data to the server
    const handleSubmit = (e) => {
        //stop the normal refresh and redirect with route param
        e.preventDefault();

        //format the data
        const data = {
            username: formData.username,
            //hash the data before sending for storage
            password: bcrypt.hashSync(formData.password),
        };
        //issue where cors does not allow changing the content type to application/json
        console.log(data);
        fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(formData),
        })
            .then((response) => response.json())
            .then((data) => {
                //debug to show the username of the login
                getUserInfo(data.authentication.name);
            });
    };

    //this will be to alert the user they have logged in and their info has been retrieved
    const getUserInfo = (e) => {
        if (e !== "") {
            fetch("http://localhost:8080/getByUsername?username=" + e, {
                method: "GET",
                headers: {
                    authorization: "",
                    "Content-type": "application/json",
                    accept: "",
                },
            })
                .then((response) => response.json())
                .then((data) => {
                    console.log(data);
                    alert("Welcome " + data.f_name + "!");
                });
        }
    };

    //handles the change for each form value
    const handleChange = (e) => {
        //saves the name of the field being passed (username)
        const name = e.target.name;
        //saves the value of the field being passed ("thisismyusername")
        const value = e.target.value;
        //sets the form so that it is updated and ready to send back
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
                        value={formData.password || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <input type="submit" value={"Submit" || "Submit"} />
            </form>
        </div>
    );
}

export default LoginForm;
