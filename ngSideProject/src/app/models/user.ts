import { Address } from './address';

export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  phone: string;
  address: Address;
  firstName: string;
  lastName: string;
  role: string;
  enabled: boolean;

  constructor(
    id?: number,
    password?: string,
    email?: string,
    phone?: string,
    address?: Address,
    firstName?: string,
    lastName?: string,
    role: string = 'standard',
    enabled: boolean = true
    )
    {
      this.id = id;
      this.username = email;
      this.password = password;
      this.email = email;
      this.phone = phone;
      this.address = address;
      this.firstName = firstName;
      this.lastName = lastName;
      this.role = role;
      this.enabled = enabled;
    }
}
