import { Address } from './address';

export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  phone: string;
  address: Address;

  constructor(id?: number, username?: string, password?: string,
              email?: string, phone?: string, address?: Address) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.email = email;
      this.phone = phone;
      this.address = address;
    }
}
