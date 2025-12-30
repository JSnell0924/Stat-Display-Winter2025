package org.example.Features.disk;

import java.util.List;

import org.example.App;

import oshi.SystemInfo;
import oshi.hardware.Display;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.OSFileStore;
import oshi.util.tuples.Pair;

public class DiskInfo {
    public static void getDiskInfo() {
        
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hw = si.getHardware();
        Sensors sensors = hw.getSensors();
        List<HWDiskStore> diskStores = hw.getDiskStores();
        //Pair<Integer, Integer> dsPartIdx = getDiskStoreAndPartitionForPath(filePath, diskStores);

        List<OSFileStore> diskStorage = si.getOperatingSystem().getFileSystem().getFileStores();

        for (HWDiskStore disk : diskStores) {
            System.out.println("Name: " + disk.getModel());
        }

        for (OSFileStore store : diskStorage) {
            double storageLeft = store.getFreeSpace() / Math.pow(1000, 3);
            double totalStorage = store.getTotalSpace() / Math.pow(1000, 3);
            System.out.println("Total Storage: " + totalStorage);
            System.out.println("Storage left: " + storageLeft);
        }

       // System.out.println("PushPullTest");
    }
}


 //double cpuTemp = sensors.getCpuTemperature();
        //System.out.println(cpuTemp);
        //List<Display> gpuTemp = hw.getDisplays();
        //System.out.println(gpuTemp);