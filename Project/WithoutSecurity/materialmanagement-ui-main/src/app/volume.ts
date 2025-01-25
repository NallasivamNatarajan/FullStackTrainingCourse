export class Volume {
    volumeId!: number;
    volumeMeterics!: string;

    constructor(volumeId: number,
        volumeMeterics: string) {
        this.volumeId = volumeId;
        this.volumeMeterics = volumeMeterics;
    }
}
