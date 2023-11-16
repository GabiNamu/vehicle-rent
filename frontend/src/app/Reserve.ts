import { Vehicle } from "./Vehicle";

export interface AddReserve {
  initial_date: Date;
  finalDate: Date;
  name: string;
  phone: string;
}

export interface Reserve {
  id: number;
  vehicle: Vehicle,
  initialDate: Date;
  finalDate: Date;
  name: string;
  phone: number;
}