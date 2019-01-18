6.6 性能
影响并行流的主要因素：
数据大小
源数据结构
装箱
核的数量
单元处理开销

底层并行流沿用fork/join框架
fork递归分解问题，每段并行执行，最终由join合并结果，返回之后的值。

性能好
ArrayList、数组或IntStream.range，支持随机读取。
性能一般
HashSet、TreeSet,不易公平分解
性能差
LinkedList、Streams.iterate、BufferedReader.lines
流单独操作每一块种类分
无状态
过程不必维护
map、filter、flatMap
有状态
维护状态所需开销和限制
sorted、distinct、limit
6.7并行化数组操作
