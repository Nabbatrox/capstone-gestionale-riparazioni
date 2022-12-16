export class User {
    id: number | undefined;
    username: string;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    active: boolean;
    role: string[];

    constructor(id: number | undefined, username: string, firstname: string, lastname: string, email: string, password: string, active: boolean, role: string[]) {
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
