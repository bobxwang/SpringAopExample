#### Aspect Oriented Programming

##### 静态代理

##### 动态代理
> 代理会对目标类所有方法进行处理，因此我们需要判断method的类型，由此spring aop引入了一个Pointcut切点的概念，就是相当于对方法的判断，哪些方法要拦截，哪些不需要拦截

- JDK代理
  * 代理对象和目标对象实现了共同的接口  
  * 拦截器必须实现InvocationHanlder接口  
- Cglib代理 
  * 代理对象是目标对象的子类，因为是继承，所有 final 的不会起作用的
  * 拦截器必须实现MethodInterceptor接口  

##### Spring Aop

###### Advice

* 织入

  > 对方法的增强
  * 前置增强
  * 后置增强
  * 环绕增强
  * 异常增强

* 引入

  > 对类的增强，想像一下，如果某个类实现了A接口但没实现B接口，那么该类可以调用B接口的方法吗，答案是可以，这就是引入的作用

###### Pointcut

> 切点，即拦截的匹配条件

###### Advisor

> 切面，由Advice跟Pointcut组成 
