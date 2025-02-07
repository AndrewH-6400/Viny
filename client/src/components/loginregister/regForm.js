import React, { useState } from "react";

export default function RegForm() {
    const [formData, setFormData] = useState({});

    const handleSubmit = (e) => {
        alert(formData.username);
    };

    const handleChange = (e) => {
        const username = e.target.username;
        const pswd = e.target.pswd;
        setFormData((values) => ({ ...values, [username]: pswd }));
    };

    return (
        <div className="h-fit w-fit mx-auto my-8">
            <form onSubmit={handleSubmit}>
                <label>Username:</label>
                <input
                    className="text-black"
                    type="text"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                />

                <input type="submit" />
            </form>
        </div>
    );
}
