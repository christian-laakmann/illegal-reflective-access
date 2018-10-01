To reproduce the error:

1. Build the project using JDK 8
2. Run the built JAR file using JDK 11

```
mvnw package
path/to/jdk11/bin/java -jar --illegal-access=debug -jar target/demo-0.0.1-SNAPSHOT.jar
```

Result:

```
WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils (jar:file:/C:/Users/***/spring-data-reflection-access/target/demo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/spring-core-5.1.0.RELEASE.jar!/) to 
method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)                                                                                                                                      
        at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:521)                                                                                                                                                     
        at org.springframework.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:486)                                                                                                                                                     
        at org.springframework.data.mapping.model.ClassGeneratingPropertyAccessorFactory$PropertyAccessorClassGenerator.generateCustomAccessorClass(ClassGeneratingPropertyAccessorFactory.java:321)                                          
        at org.springframework.data.mapping.model.ClassGeneratingPropertyAccessorFactory.createAccessorClass(ClassGeneratingPropertyAccessorFactory.java:195)                                                                                 
        at org.springframework.data.mapping.model.ClassGeneratingPropertyAccessorFactory.potentiallyCreateAndRegisterPersistentPropertyAccessorClass(ClassGeneratingPropertyAccessorFactory.java:181)                                         
        at org.springframework.data.mapping.model.ClassGeneratingPropertyAccessorFactory.getPropertyAccessor(ClassGeneratingPropertyAccessorFactory.java:91)                                                                                  
        at org.springframework.data.mapping.model.BasicPersistentEntity.getPropertyAccessor(BasicPersistentEntity.java:455)                                                                                                                   
        at org.springframework.data.mapping.model.IdPropertyIdentifierAccessor.<init>(IdPropertyIdentifierAccessor.java:54)                                                                                                                   
        at org.springframework.data.mapping.model.BasicPersistentEntity.getIdentifierAccessor(BasicPersistentEntity.java:471)                                                                                                                 
        at org.springframework.data.mongodb.core.EntityOperations$AdaptibleMappedEntity.of(EntityOperations.java:575)                                                                                                                         
        at org.springframework.data.mongodb.core.EntityOperations$AdaptibleMappedEntity.access$100(EntityOperations.java:554)                                                                                                                 
        at org.springframework.data.mongodb.core.EntityOperations.forEntity(EntityOperations.java:105)                                                                                                                                        
        at org.springframework.data.mongodb.core.MongoTemplate.save(MongoTemplate.java:1340)                                                                                                                                                  
        at org.springframework.data.mongodb.core.MongoTemplate.save(MongoTemplate.java:1330)                                                                                                                                                  
        at com.example.demo.DataService.saveData(DataService.java:21)                                                                                                                                                                         
        at com.example.demo.DataService$$FastClassBySpringCGLIB$$3fb8e7d1.invoke(<generated>)                                                                                                                                                 
        at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)                                                                                                                                                           
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:746)                                                                                                                      
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)                                                                                                                          
        at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:139)                                                                                             
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)                                                                                                                          
        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)                                                                                                                        
        at com.example.demo.DataService$$EnhancerBySpringCGLIB$$cc99431f.saveData(<generated>)                                                                                                                                                
        at com.example.demo.DemoApplication.scheduled(DemoApplication.java:28)                                                                                                                                                                
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement.invoke(InitDestroyAnnotationBeanPostProcessor.java:363)                                                                       
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:307)                                                           
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:136)                                                               
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:419)                                                              
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1736)                                                                                          
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:576)                                                                                             
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:498)                                                                                               
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320)                                                                                                                     
```
