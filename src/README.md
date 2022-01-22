# About

Checkpoints are small real-world problems that will make you use the concepts you have learned so far.

Differently from coding challenges available on different websites, the problems here are primarily focused on business problems instead of logical problems.

Each checkpoint will be built on top of each other. Meaning, if you do not code properly this challenge, in the next one there is a chance you will have to properly fix your code before continuing.

At first glance the checkpoints will appear very detailed, but there are decisions you will have to make that are not described explicitly.
This is part of a developer's daily life. It is your job to make these decisions and explain pros, cons, what made you take the way you chose to solve the problem, and what other ways you had.

Do your best, we guarantee that the concepts you must use here were already covered in the courses.

# Let's get started

## First checkpoint

At this point you just finish the basics about programming and Java.

You should be familiar with basic concepts of programming and Java syntax for things like if, switch, for, while, arrays etc.
This checkpoint will require you to use this knowledge to create a very simple program for the problem described below.

## Description

This exercise will require you to create a small menu and print automakers cars available.

Take a look at the multidimensional array (matrix) below.

| GM        	| Hyundai  	| Volkswagen 	| Audi 	| Mercedes 	| Peugeot 	|
|-----------	|----------	|------------	|------	|----------	|---------	|
| Suburban  	| Azera    	| Golf       	| A4   	| C 180    	| 206     	|
| Malibu    	| Sonata   	| Jetta      	| Q7   	| C 200    	| 208     	|
| Silverado 	| Veloster 	| Polo       	| R8   	| GLA 200  	| 2008    	|

This matrix represents vehicles and its respective automakers. In this exercise your task is the following:

1. Create a class called Application
2. Create and initialize a multidimensional array with the same values as in the table above, for this you can initialize them manually in the code (hard coded)
3. Create a menu where it shows the automaker list enumerated that keeps alive until the user selects an exit point, for example:

```text 
1 - GM
2 - Hyundai
...
0 - Exit
```

3. Based on the user automaker selection, print its available cars. For example, given the user selects 1, it should print something like

```text
Available vehicles:
GM
Suburban
Malibu
Silverado
```

4. Ask the user if he wants to select another option or exit the application, something like

```text
Do you wish to continue?
0 - No
1 - Yes
```

Don't forget to validation checks where necessary.