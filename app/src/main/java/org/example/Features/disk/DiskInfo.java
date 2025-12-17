package org.example.Features.disk;

import java.util.List;

import org.example.App;

import oshi.SystemInfo;
import oshi.hardware.Display;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

public class DiskInfo {
    public static void getDiskInfo() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hw = si.getHardware();
        Sensors sensors = hw.getSensors();
        //double cpuTemp = sensors.getCpuTemperature();
        //System.out.println(cpuTemp);
        //List<Display> gpuTemp = hw.getDisplays();
        //System.out.println(gpuTemp);

        List<HWDiskStore> diskStorage = hw.getDiskStores();
        System.out.println(diskStorage);

        System.out.println("PushPullTest");
    }
}
