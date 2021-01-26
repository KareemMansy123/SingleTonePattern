# SingleTonePattern
There are cases when you need only one instance of a class. So, whenever you call the object of the class, 
then the new object should not be created(only one-time object creation will be there). This design pattern provides a global point of access to a class. For example,
the network connection in an application should be done once and not every time because it is a very expensive process. So in these cases, we can use a singleton.

so here we used SingleTon Patter with MVVM Pattern 
and we used retrofite as newwork connection library with KOTLIN Coroutines
