# 4 pillars of Object Oriented Programming
### 1. Abstraction
- Abstraction of Data or **Hiding** of Information
	- or simply: what are the things the user is concerned about
		- example: `Uber app`
			- step-by-step process of or ordering a ride
				1. When you want to book a ride, you have to Enter a pick-up point
				2. After done with touching on Enter a pick-up point, now you have to enter your destination place
				3. After done with typing the destination place now you have to select a place from the suggestion list
				4. After done with selecting one from the suggestion list, you found your estimation of time and cost
			- all actions done with just *one touch*; user don’t need to worry about the behind the scenes (like connecting to `Google Maps`, `algorithms` used to assign a driver...)
	- this is **useful** because:
		- it `reduces the complexity` of viewing the things
		- it `avoids code duplication` and increases reusability
		- it helps to `increase security` of an application or program as only important details are provided to the user
	- abstraction can be achieved with either abstract classes or interfaces
		* the abstract keyword is a non-access modifier, used for classes and methods:
			* **abstract class**: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class)
					
					public abstract class Teacher { ... }
			* **abstract method**: can only be used in an abstract class, and it does not have a body; the body is provided by the subclass (inherited from)
					
					// must be inside an abstract class
					public abstract char grade();

### 2. Polymorphism
- the ability to **redefine methods for derived classes** or we can say that object can behave in different forms
	- it occurs when we have many classes that are related to each other by inheritance
	- means: many forms
	- polymorphism uses inherited methods to perform different tasks
		- implementation of `grade()` method differs from one child class to another: this is called method **overriding**
				
				public abstract char grade();
	- another form of polymorphism is the use of methods with the same name, but with different parameters in order to perform different tasks
		- `Teacher.java` has 2 parameterized constructors and they differ only in parameters being passed to them; this is called method/constructor **overloading**
				
				public Teacher(String subject) {
					this.subject = subject;
				}

				public Teacher(String name, String subject, int age, boolean currentlyTeaching) {
					this.name = name;
					this.subject = subject;
					this.age = age;
					this.currentlyTeaching = currentlyTeaching;
				}
- this is useful because:
	- these allow us to perform a single action in different ways
	- it allows code reusability: reuse attributes and methods of an existing class when you create a new class

### 3. Encapsulation
- **Binding of Data and Functions** (that manipulate the data) together and keep both safe from outside interference and misuse
	- giving each variable/method just as much access as it needs
	- giving the outer world just enough information that they need to interact with
	- to make sure that *sensitive* data is hidden from users, we must pay close attention on **access modifiers**:
		- declare class variables/attributes as private
				private String name;
		- provide public `get` and `set` methods to access and update the value of a private variable

			    public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
- this is useful because:
	- it allows better control of class attributes and methods
		- class attributes can be made **read-only** (if you only use the get method), or **write-only** (if you only use the set method)
	- it allows flexibility: the programmer can change one part of the code without affecting other parts
	- it increases security of data

### 4. Inheritance
- Inheritance enables new objects to take on the properties of existing objects
- `extends` keyword for defining parent and child relationship
	- In Java, it is possible to inherit attributes and methods from one class to another
			
			public class ChemistryTeacher extends Teacher {
				...
			}
- we group the "inheritance concept" into two categories:
	- subclass (child) - the class that inherits from another class: in this case `ChmistryTeacher` class is the child class
	- superclass (parent) - the class being inherited from: `Teacher` class in the parent class
- this is useful because:
	- it allows code reusability: reuse attributes and methods of an existing class when you create a new class
	- the code that is already present in base class need not be rewritten in the child class
