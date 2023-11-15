export interface addVehicle {
  model: string;
  brand: string;
  color: string;
  manufacturingYear: number;
  licensePlate: string;
}

export interface Vehicle extends addVehicle {
  id: number;
  reserved: boolean;
}

