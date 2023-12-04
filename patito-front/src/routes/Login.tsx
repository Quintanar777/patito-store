import { useState } from "react";
import DefaultLayout from "../layout/DefaultLayout"
import { useAuth } from "../auth/AuthProvider";
import { Navigate } from "react-router-dom";
import { API_URL } from "../auth/Constants";

export default function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [errorResponse, setErrorResponse] = useState("")

    const auth = useAuth();

    async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();

        try {
            const response = await fetch(`${API_URL}/auth/authenticate`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username,
                    password
                })
            });

            if(response.ok){
                console.log("login ok...");
            }

        } catch (error) {
            console.log("error login");
        }
    }

    if (auth.isAuthenticated) {
        return <Navigate to="/dashboard" />
    }

    return (
        <DefaultLayout>
            <form className="form" onSubmit={handleSubmit}>
                <h1>Login</h1>
                {!! errorResponse && <div className="errorMessage">{errorResponse}</div>}
                <label>Username</label>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />

                <label>Username</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />

                <button>Login</button>
            </form>
        </DefaultLayout>
    );


}