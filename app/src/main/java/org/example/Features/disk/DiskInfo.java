package org.example.Features.disk;

import java.util.List;

import org.example.App;

import oshi.SystemInfo;
import oshi.hardware.Display;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.util.tuples.Pair;

public class DiskInfo {
    public static void getDiskInfo() {
        
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hw = si.getHardware();
        Sensors sensors = hw.getSensors();
        List<HWDiskStore> diskStorage = hw.getDiskStores();
        //Pair<Integer, Integer> dsPartIdx = getDiskStoreAndPartitionForPath(filePath, diskStores);

        for (HWDiskStore disk : diskStorage) {
            System.out.println("Name: " + disk.getModel());
        }

        System.out.println("PushPullTest");
    }
}


 //double cpuTemp = sensors.getCpuTemperature();
        //System.out.println(cpuTemp);
        //List<Display> gpuTemp = hw.getDisplays();
        //System.out.println(gpuTemp);