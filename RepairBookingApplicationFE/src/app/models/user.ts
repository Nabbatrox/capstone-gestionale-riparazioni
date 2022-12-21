export class User {
    id: number;
    username: string;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    active: boolean;
    role: string[];

    constructor(id: number, username: string, firstname: string, lastname: string, email: string, password: string, active: boolean, role: string[]) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    
}
}
