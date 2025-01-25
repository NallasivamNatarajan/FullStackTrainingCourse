import { Category } from './category';

export interface IProduct {
  productId: number;
  productName: string;
  partNumber: string;
  description: string;
  category: Category;
  type: Type;
  length: number;
  diameter: number;
  imageUrl: string;
  driveSize: number;
  volume: Volume;
  lineNumber: string;
  quantity: number;
}

export interface Type {
  typeId: number;
  typeName: string;
}

export interface Volume {
  volumeId: number;
  volumeMeterics: string;
}

