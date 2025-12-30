package org.example.Features.cpu;

import java.util.List;

import org.example.App;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.CentralProcessor;

public class cpuInfo {
    public static void getCpuInfo() {
        SystemInfo sysinf = new SystemInfo();
        HardwareAbstractionLayer hw = sysinf.getHardware();
        CentralProcessor cpu = hw.getProcessor();
        CentralProcessor.ProcessorIdentifier processorIdentifier = cpu.getProcessorIdentifier();

        System.out.println("CPU Details");
        System.out.println("Processor Vendor: " + processorIdentifier.getVendor());
        System.out.println("Processor Name: " + processorIdentifier.getName());
        System.out.println("Processor ID: " + processorIdentifier.getProcessorID());
        System.out.println("Identifier: " + processorIdentifier.getIdentifier());
        System.out.println("Microarchitecture: " + processorIdentifier.getMicroarchitecture());
        System.out.println("Frequency (Hz): " + processorIdentifier.getVendorFreq());
        System.out.println("Frequency (GHz): " + processorIdentifier.getVendorFreq() / 1000000000.0);
        System.out.println("Number of physical packages: " + cpu.getPhysicalPackageCount());
        System.out.println("Number of physical CPUs: " + cpu.getPhysicalProcessorCount());
        System.out.println("Number of logical CPUs: " + cpu.getLogicalProcessorCount());
        System.out.printf("Total CPU usage: %.2f%%%n", cpu.getSystemCpuLoad(1000) * 100);
        System.out.println("End CPU Details");
    }
}

