import { Device } from "./device";
import { User } from "./user";

export class Booking {
    id: number | undefined;
    user!: User;
    device!: Device[];
    bookedAt!: Date;
    bookingDate!: Date;
    expiringDate!: Date;

}
