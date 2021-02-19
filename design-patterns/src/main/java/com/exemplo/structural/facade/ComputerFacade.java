package com.exemplo.structural.facade;

public class ComputerFacade {

    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade(CPU processor, Memory ram, HardDrive hd) {
        this.processor = processor;
        this.ram = ram;
        this.hd = hd;
    }

    public void start() {
        processor.freeze();
        ram.load(1, hd.read(1234, 10));
        processor.jump(1);
        processor.execute();
    }
}
