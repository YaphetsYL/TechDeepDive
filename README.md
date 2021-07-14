# TechDeepDive
## Table of Contents

* [Version](#version)
* [1. Programming Specification](#1-programming-specification)
   * [Formatting Style](#formatting-style)
   * [OOP Rules](#oop-rules)
* [2. Exception and Logs](#2-exception-and-logs)
   * [Exception](#exception)
   * [Logs](#logs)
* [3. Aerospike Rules](#3-areospike-rules)

## Version

### Initial Version

These rules consolidates programming practices from code review sessions. Some of the rules are referred from Alibaba Java Coding Guidelines. 

## <font color="green">1. Programming Specification</font>

### <font color="green">Formatting Style</font>
1\. **[Mandatory]** Rules for braces. If there is no content, simply use *{}* in the same line. Otherwise:    
&emsp;&emsp;1) No line break before the opening brace.   
&emsp;&emsp;2) Line break after the opening brace.     
&emsp;&emsp;3) Line break before the closing brace.   
&emsp;&emsp;4) Line break after the closing brace, *only if* the brace terminates a statement or terminates a method body, constructor or named class. There is *no*    line break after the closing brace if it is followed by `else` or a comma.

2\. **[Mandatory]** No space is used between the '(' character and its following character. Same for the ')' character and its preceding character. Refer to the *Positive Example* at the 5th rule.  

3\. **[Mandatory]** There must be one space between keywords, such as if/for/while/switch, and parentheses.

4\. **[Mandatory]** There must be one space at both left and right side of operators, such as '=', '&&', '+', '-', *ternary operator*, etc.

5\. **[Mandatory]** Each time a new block or block-like construct is opened, the indent increases by four spaces. When the block ends, the indent returns to the previous indent level. Tab characters are not used for indentation.   
> <font color="#977C00">Note: </font>To prevent tab characters from being used for indentation, you must configure your IDE. For example, "Use tab character" should be unchecked in IDEA, "insert spaces for tabs" should be checked in Eclipse.  
> <font color="#019858">Positive example: </font>     
```java 
public static void main(String[] args) {
    // four spaces indent
    String say = "hello";
    // one space before and after the operator
    int flag = 0;
    // one space between 'if' and '('; 
    // no space between '(' and 'flag' or between '0' and ')'
    if (flag == 0) {
        System.out.println(say);
    }
    // one space before '{' and line break after '{'
    if (flag == 1) {
        System.out.println("world");
    // line break before '}' but not after '}' if it is followed by 'else'
    } else {  
        System.out.println("ok");
    // line break after '}' if it is the end of the block
    }
}
```

6\. **[Mandatory]** Java code has a column limit of 120 characters. Except import statements, any line that would exceed this limit must be line-wrapped as follows:   
&emsp;&emsp;1) The second line should be intented at 4 spaces with respect to the first one. The third line and following ones should align with the second line.      
&emsp;&emsp;2) Operators should be moved to the next line together with following context.    
&emsp;&emsp;3) Character '.' should be moved to the next line together with the method after it.    
&emsp;&emsp;4) If there are multiple parameters that extend over the maximum length, a line break should be inserted after a comma.   
&emsp;&emsp;5) No line breaks should appear before parentheses.  
> <font color="#019858">Positive example: </font> 
```java
StringBuffer sb = new StringBuffer();
// line break if there are more than 120 characters, and 4 spaces indent at
// the second line. Make sure character '.' moved to the next line 
// together.  The third and fourth lines are aligned with the second one. 
sb.append("a").append("b").
    .append("c")...
    .append("d")...
    .append("e");
```
> <font color="#FF4500">Counter example: </font>
```java
StringBuffer sb = new StringBuffer();
// no line break before '('
sb.append("a").append("b")...append
    ("z");  
// no line break before ',' if there are multiple params
invoke(args1, args2, args3, ...
    , argsX);
```

7\. **[Mandatory]** There must be one space between a comma and the next parameter for methods with multiple parameters.   
> <font color="#019858">Positive example: </font>One space is used after the *'<font color="blue">,</font>'* character in the following method definition.
```java
f("a", "b", "c");
```

8\. **[Mandatory]** The charset encoding of text files should be *UTF-8* and the characters of line breaks should be in *Unix* format, instead of *Windows* format.

9\. **[Recommended]** It is unnecessary to align variables by several spaces.   
> <font color="#019858">Positive example: </font> 
```java
int a = 3;
long b = 4L;
float c = 5F;
StringBuffer sb = new StringBuffer();
```
> <font color="#977C00">Note: </font>It is cumbersome to insert several spaces to align the variables above.   

10\. **[Recommended]** Use a single blank line to separate sections with the same logic or semantics.
> <font color="#977C00">Note: </font>It is unnecessary to use multiple blank lines to do that.

11\. **[Recommended]** Use IDEA to format code (win: ctrl+alt+l, mac: option+command+l; or Code --> Reformat Code)

### <font color="green">OOP Rules</font>

1\. **[Mandatory]** Since `NullPointerException` can possibly be thrown while calling the *equals* method of `Object`, *equals* should be invoked by a constant or an object that is definitely not *null*.  
 > <font color="#019858">Positive example: </font> `"test".equals(object);`   
 > <font color="#FF4500">Counter example: </font> `object.equals("test");`    
 > <font color="#977C00">Note: </font>`java.util.Objects#equals` (a utility class in JDK7) is recommended. 

2\. **[Mandatory]** Use the `equals` method, rather than reference equality '==', to compare primitive wrapper classes.
 > <font color="#977C00">Note: </font>Consider this assignment: `Integer var = ?`. When it fits the range from <font color="blue">-128 to 127</font>, we can use `==` directly for a comparison. Because the `Integer` object will be generated by `IntegerCache.cache`, which reuses an existing object. Nevertheless, when it fits the complementary set of the former range, the `Integer` object will be allocated in the heap, which does not reuse an existing object. This is a pitfall. Hence the `equals` method is recommended.
 



## <font color="green">2. Exception and Logs</font>

### <font color="green">Exception</font>

1\. **[Mandatory]** Do not catch *Runtime* exceptions defined in *JDK*, such as `NullPointerException` and `IndexOutOfBoundsException`. Instead, pre-check is recommended whenever possible.  
> <font color="#977C00">Note: </font>Use try-catch only if it is difficult to deal with pre-check, such as `NumberFormatException`.  
> <font color="#019858">Positive example: </font>```if (obj != null) {...}```  
> <font color="#FF4500">Counter example: </font> ```try { obj.method() } catch(NullPointerException e){…}```


### <font color="green">Logs</font>
1\. **[Mandatory]** Do not use API in log system (Log4j, Logback) directly. @SLF4J annotation is recommended to use instead.
```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
```


2\. **[For Reference]** Duff's device 
```java
//todo
```

3\. **[Mandatory]** Logs at *TRACE / DEBUG / INFO* levels must use either conditional outputs or placeholders.
> <font color="#977C00">Note: </font>`logger.debug ("Processing trade with id: " + id + " symbol: " + symbol);` If the log level is warn, the above log will not be printed. However, it will perform string concatenation operator. `toString()` method of *symbol* will be called, which is a waste of system resources.   
> <font color="#019858">Positive example: </font>
```java
if (logger.isDebugEnabled()) { 
    logger.debug("Processing trade with id: " + id + " symbol: " + symbol); 
}     
```  
> <font color="#019858">Positive example: </font>
```java
logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
```

> <font color="#FF4500">Counter example: </font> 
```java
logger.debug("Processing trade with id: " + id + " symbol: " + symbol); 
```

## <font color="green">3. Aerospike Rules</font>
```java
//todo
```