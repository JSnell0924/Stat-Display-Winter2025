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

        boolean isMac = System.getProperty("os.name").toLowerCase().contains("mac");
        double divisor = isMac ? Math.pow(1000, 3) : Math.pow(1024, 3);

    

        HWDiskStore mainDisk = null;
        long maxSize = 0;
        for (HWDiskStore disk : diskStores) {
            if (disk.getSize() > maxSize) {
                maxSize = disk.getSize();
                mainDisk = disk;
            }
        }
        
        if (mainDisk != null) {
            System.out.println("Name: " + mainDisk.getModel());
        }

        for (OSFileStore store : diskStorage) {
            String mount = store.getMount();
            String name = store.getName();

            if (mount.startsWith("/System") || 
                mount.startsWith("/private") ||
                mount.contains("com.apple") ||
                mount.contains("@") ||  // APFS snapshots
                name.contains("com.apple") ||
                store.getTotalSpace() == 0) {
                continue;  // Skip this volume
            }

            if (mount.contains("/sys") || mount.contains("/proc") || mount.contains("/dev") || mount.contains("/run")) {
                continue;
            }

            double storageLeft = store.getUsableSpace() / divisor;
            double totalStorage = store.getTotalSpace() / divisor;
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