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

        long[][] prevTicks = cpu.getProcessorCpuLoadTicks();

        System.out.println("CPU Details");
        System.out.println("Processor Vendor: " + processorIdentifier.getVendor());
        System.out.println("Processor Name: " + processorIdentifier.getName());
        System.out.println("Processor ID: " + processorIdentifier.getProcessorID());
        System.out.println("Identifier: " + processorIdentifier.getIdentifier());
        System.out.println("Microarchitecture: " + processorIdentifier.getMicroarchitecture());

        System.out.println("Number of physical packages: " + cpu.getPhysicalPackageCount());
        System.out.println("Number of physical CPUs: " + cpu.getPhysicalProcessorCount());
        System.out.println("Number of logical CPUs: " + cpu.getLogicalProcessorCount());
        System.out.printf("Total CPU usage: %.2f%%%n", cpu.getSystemCpuLoad(1000) * 100);
        
        double[] load = cpu.getProcessorCpuLoadBetweenTicks(prevTicks);
        long[] freqs = cpu.getCurrentFreq();

       for (int i = 0; i < load.length; i++) {
            double usagePercent = load[i] * 100;
            String freqStr;

            if (freqs != null && i < freqs.length && freqs[i] > 0) {
                freqStr = String.format("%.2f GHz", freqs[i] / 1_000_000_000.0);
            } else {
                freqStr = "N/A";
            }
            System.out.printf("CPU Core %d usage: %.2f%%, frequency: %s%n", i, usagePercent, freqStr);
        }
        System.out.println("End CPU Details");
    }
}

