import React, { useState } from "react";

export default function RegForm() {
    const [formData, setFormData] = useState({});

    //format and submit the data to the server
    const handleSubmit = (e) => {
        //stop the normal refresh and redirect with route param
        e.preventDefault();
        //show the form data for debugging
        //console.log(formData);
        //format the data
        const data = {
            f_name: formData.f_name,
            l_name: formData.l_name,
            email: formData.email,
            username: formData.username,
            password: formData.password,
        };
        //issue where cors does not allow changing the content type to application/json
        console.log(data);
        fetch("http://localhost:8080/saveUser", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(formData),
        }).then((result) => console.log(result));
        //setFormData({});

        //console.log(formData);
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

    //html for the form
    //each value uses value || "" to avoid an error
    return (
        <div className="h-fit w-fit mx-auto my-8">
            <form onSubmit={handleSubmit} className="flex flex-col">
                <div className="h-fit w-fit my-2">
                    <label className="pr-1">First Name:</label>
                    <input
                        className="text-black"
                        type="text"
                        name="f_name"
                        value={formData.f_name || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <div className="h-fit w-fit my-2">
                    <label className="pr-1">Last Name:</label>
                    <input
                        className="text-black"
                        type="text"
                        name="l_name"
                        value={formData.l_name || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <div className="h-fit w-fit my-2">
                    <label className="pr-1">E-mail:</label>
                    <input
                        className="text-black"
                        //change type to email to verify the entered data is an email after testing
                        type="text"
                        name="email"
                        value={formData.email || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
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

                <div className="h-fit w-fit my-2">
                    <label className="pr-1">Re-Enter Password:</label>
                    <input
                        className="text-black"
                        type="password"
                        name="pswd2"
                        value={formData.pswd2 || ""}
                        onChange={(e) => handleChange(e)}
                    />
                </div>
                <input type="submit" value={"Submit" || "Submit"} />
            </form>
        </div>
    );
}
