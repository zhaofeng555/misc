代理模式：
是常用的java设计模式，它的特征是代理类和委托类有同样的接口，
代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及时候处理消息等。
代理类与委托类之间通常会存在关联关系，一个代理类的对象与一个委托类的对象
的关联，代理类的对象本身并不真正实现业务，而是通过调用委托类的对象的相关方法，来提供特定的服务。

按照创建时期分：
静态代理：由程序员创建或特定的工具生成源代码，在对其编译。
	在运行前，代理类的.class文件就存在了。
动态代理：在程序运行时，运用反射机制动态创建而成。