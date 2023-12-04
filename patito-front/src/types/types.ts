export interface AuthResponse {
    body: {
        jwt: string
    };
}

export interface AuthResponseError {
    body: {
        error: string
    };
}

export interface User {
    username: string
}