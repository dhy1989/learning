#jv
##jvm优化的一些参数
##jvm参数参数类型
  * 标配参数    
    java -version     
    java -help  
    java -showversion
  * X参数(了解)  
    -Xint 解释执行  
    -Xcomp 第一次使用就编译成本地代码  
    -Xmixed 混合模式
  * __XX参数__  
   Boolean类型 -XX:+或者-某个属性值 (+表示开启 -表示关闭)  
   KV设值类型 例如:-XX:MetaspaceSize=128m  
   两个经典参数: -Xms和-Xmx 这2个如何解释:-Xms相当于-XX:initialHeapSize -Xmx箱单于-XX:MaxHeapSize
##查看参数
  * jps 
  * jinfo  -flag 具体参数 pid
  * jinfo  -flags pid
  * java -XX:+PrintFlagsInitial 所有初始化参数值
  * java -XX:+PrintFlagsFinal -version 修改过后的参数值
    

##jdk自带的一些工具参数
(1)java -XX:+PrintCommandLineFlags -version 查看当前使用的是哪种垃圾收集器
(2)jps [options] [hostid]  JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程
    option参数:
        -l : 输出主类全名或jar路径
        -q : 只输出LVMID
        -m : 输出JVM启动时传递给main()的参数
        -v : 输出JVM启动时显示指定的JVM参数
        其中[option]、[hostid]参数也可以不写
     例: jps -l   
        11520 org.jetbrains.jps.cmdline.Launcher
        13092 sun.tools.jps.Jps
        17096 com.cmhb.Application
        13244 org.jetbrains.jps.cmdline.Launcher
(3)jstat [option] LVMID [interval] [count] jstat(JVM statistics Monitoring)是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。
 
(4)jmap [option] LVMID map(JVM Memory Map)命令用于生成heapdump文件，如果不使用这个命令，还阔以使用-XX:+HeapDumpOnOutOfMemoryError参数来让虚拟机出现OOM的时候自动生成dump文件.jmap不仅能生成dump文件，还阔以查询finalize执行队列、Java堆和永久代的详细信息，如当前使用率当前使用的是哪种收集器等
    
    