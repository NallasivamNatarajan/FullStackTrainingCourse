export class Type {
    typeId!: number;
    typeName!: string;

    constructor(typeId: number,
        typeName: string) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}
