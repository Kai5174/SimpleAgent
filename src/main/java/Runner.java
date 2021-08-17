import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Runner {
    public static void main(String[] args) throws IOException, AttachNotSupportedException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String myPid = name.split("@")[0];
        System.out.printf("pid is: %s\n", myPid);
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter target pid");
        File thisJar = new File("SimpleAgent.jar");
        int pid = reader.nextInt();
        reader.close();
        try {
            VirtualMachine vm = VirtualMachine.attach(String.valueOf(pid));
            vm.loadAgent(thisJar.getAbsolutePath());
            vm.detach();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
