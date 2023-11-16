import { Reserve } from "./Reserve";

export interface addVehicle {
  model: string;
  brand: string;
  color: string;
  manufacturing_year: number;
  license_plate: string;
}

export interface Vehicle {
  id: number;
  model: string;
  brand: string;
  color: string;
  manufacturingYear: number;
  licensePlate: string;
  reserve: Reserve | null;
}

