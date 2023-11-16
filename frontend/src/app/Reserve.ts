import { Vehicle } from "./Vehicle";

export interface AddReserve {
  initial_date: Date;
  final_date: Date;
  name: string;
  phone: string;
}

export interface Reserve {
  id: number;
  initialDate: Date;
  finalDate: Date;
  name: string;
  phone: number;
}