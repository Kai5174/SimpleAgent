# SimpleAgent
简易的javaagent实现，输入目标PID即可将Agent注入到目标jvm中,目前的agent是列出所有jvm内存的class，下载后修改即可。

## Example
注入到自身进程中，jdk1.8
```bash
E:\Java项目\SimpleAgent\out\artifacts\SimpleAgent_jar>java -jar SimpleAgent.jar
pid is: 24212
Enter target pid
24212
sun.util.resources.zh.CurrencyNames_zh_CN
sun.text.resources.zh.FormatData_zh_CN
sun.text.resources.zh.FormatData_zh
SimpleAgent.Agent
com.sun.tools.attach.AttachOperationFailedException
sun.tools.attach.WindowsVirtualMachine$PipedInputStream
com.sun.tools.attach.AgentInitializationException
com.sun.tools.attach.AgentLoadException
sun.jvmstat.perfdata.monitor.AliasFileParser$Token
忽略后面的输出
```

注入到自身进程中，jdk13，由于大于jdk9会对Agent动态加载进行阻断，因此会失败。参考 https://xz.aliyun.com/t/10075
```bash
E:\Java项目\SimpleAgent\out\artifacts\SimpleAgent_jar>"C:\Program Files\Java\jdk-13.0.1\bin\java.exe" -jar SimpleAgent.jar
pid is: 25152
Enter target pid
25152
java.util.ServiceConfigurationError: com.sun.tools.attach.spi.AttachProvider: Provider sun.tools.attach.WindowsAttachProvider not found
        at java.base/java.util.ServiceLoader.fail(ServiceLoader.java:590)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.nextProviderClass(ServiceLoader.java:1212)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNextService(ServiceLoader.java:1221)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNext(ServiceLoader.java:1265)
        at java.base/java.util.ServiceLoader$2.hasNext(ServiceLoader.java:1300)
        at java.base/java.util.ServiceLoader$3.hasNext(ServiceLoader.java:1385)
        at jdk.attach/com.sun.tools.attach.spi.AttachProvider.providers(AttachProvider.java:258)
        at jdk.attach/com.sun.tools.attach.VirtualMachine.attach(VirtualMachine.java:200)
        at Runner.main(Runner.java:20)
java.io.IOException: Can not attach to current VM
        at jdk.attach/sun.tools.attach.HotSpotVirtualMachine.<init>(HotSpotVirtualMachine.java:75)
        at jdk.attach/sun.tools.attach.VirtualMachineImpl.<init>(VirtualMachineImpl.java:48)
        at jdk.attach/sun.tools.attach.AttachProviderImpl.attachVirtualMachine(AttachProviderImpl.java:69)
        at jdk.attach/com.sun.tools.attach.VirtualMachine.attach(VirtualMachine.java:207)
        at Runner.main(Runner.java:20)
```
