# tb-java-tool

Java bindings for the [Teambition Java Tool](https://github.com/sijifeng/tb_java_tool)




## Add a dependency


### Maven

Add jitpack to your repositories in `pom.xml` or `settings.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://www.jitpack.io</url>
    </repository>
</repositories>
```  

and add the project declaration to your `pom.xml`:

```xml
<dependency>
  <groupId>com.teambition</groupId>
  <artifactId>tb-java-tool</artifactId>
  <version>0.0.1</version>
</dependency>
```

### Gradle

Add jitpack to your `repositories` block:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

and add the project to the `dependencies` block in your `build.gradle`:

```groovy
dependencies {
  compile 'com.teambition:tb-java-tool:0.0.1'
}  
```

### SBT

Add jcenter to your `resolvers` in your `build.sbt`:

```scala
resolvers += "jitpack" at "https://www.jitpack.io"
```

and add the project to your `libraryDependencies` in your `build.sbt`:

```scala
libraryDependencies += "com.teambition" % "tb-java-tool" % "0.0.1"
```

## Resources

Resources this API supports:

- [Message](#message)
- [Mail](#mail)





## Usage

### Message

```java
// Init model
Message message = new Message("apiKey");
// send  [_organizationId 、 objects（发送对象 数组）、消息内容 、 发送对象类型]

type 可选值(groups、projects、users)
message.send("你所在企业的组织编号", "object", "content", "type");
```

### Mail

_Contacts were added in version 1.1 of the client._

```java
// 初始化发送信息 参数为 发送邮箱 、授权码
MailMessage mailFactory = new MailMessage("你的邮箱", "你的授权码");
// 发送一条消息 subject 、 content 、 sendto（数组）
mailFactory.send("test mail", "test mail 12345", new String[]{"需要发送的邮箱"});
```

