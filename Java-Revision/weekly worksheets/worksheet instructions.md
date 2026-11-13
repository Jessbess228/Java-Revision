# Task 3

Draw a 20 by 20 grid on a 720x720 window. Each cell in the grid should be 35 pixels high and wide and the grid should be drawn 10 pixels off the top and left borders of the screen. To do this, you should use the `Graphics` class from the Java libraries. Be sure to consult the tips video for this task (it is a link in iLearn). Without it, you will be very confused.

# Task 4

The "grid" has no identity - it is just drawn. Later on we will need to do lots of things "with" this grid. We will modify it and adjust it and ask it questions. Our task here is to refactor the program to give this grid an identity. We will create an object to represent the grid and will give that object its own `paint` method for drawing the grid.

We will also need to give an identity to each "cell" of the grid and make each cell responsible for it's own painting to the screen.

Modify the program to make these things happen. Make a `Grid` class and a `Cell` class and organise them in a sensible way. What fields and methods should each class have?

# Task 5

Anything that is a `JFrame` or `JPanel` can find out the position of the mouse using `getMousePosition`. Modify your program so that mousing over a cell will "highlight" it. Highlighted cells should be drawn in grey. You may have to think about how you will get the mouse position from the place you can read it, to the place it is needed (the `paint` method of a `Cell` object).

# Task 6

Our `Cell` class is really a specialised rectangle and the Java API already has a `Rectangle` class. Have `Cell` inherit from `java.awt.Rectangle` (https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html). It will be good to call "super" in the `Cell` constructor and to use the `contains` method that comes in `Rectangle` instead of your own. NB: The `contains` we wrote was graceful when given a `null` pointer for the point, the one from `Rectangle` is not, you will need to "protect" it in some way.

# Task 7

Define a `Stage` class that can contain one `Grid` object and many `Actor` objects. There must be three separate actors, each a subclass of a `Actor` _interface_ and each must have its own `paint` method. The `paint` method must take a `Graphics` parameter and draw the actor on that graphic. Have the `paint` method specified in the `Actor` interface and have each subclass define it.

Since `Actors` are drawing themselves, they need to know where they are on the screen so each will have a `Cell` field (that is set in the constructor) indicating where on the grid they are.

Have the program start with 1 grid and 3 actors:

* Rabbit (drawn white)
* Lion (drawn red)
* Puppy (drawn green)

# Task 8

Have a close look at your `Rabbit`, `Lion` and `Puppy` classes. If they are anything like mine they are _all the same except for the colour they use_. This repetition is "a bad thing" because if the same thing is done in three different places, we need to remember that updating one requires us to update all three.

Is there a place that you could put all the common parts?

💡 Will this work given what you currently have? If not, what would we need to change?

# Task 9

Draw a picture of the inheritance hierarchy you have created. You should (loosely) use [UML notation](http://www.csci.csusb.edu/dick/cs201/uml.html) for your diagram. You are using UML in this case, and all through this course, only for "a rough sketch of an idea".

# Task 10

Did you notice the repetition in the stage paint method? All three actors have the `paint` method called on them. In fact, we might later want to have dozens of actors on the stage at any one time, we don't want dozens of calls to `someone.paint(g);`. What we need is a collection to store all the actors, something like an array that we can put them all in. Then we can just loop over that array and call `paint` on every element. _I think_ we should use an `ArrayList` (https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). Notice it is a generic collection? You will need to use generics to make this work. Put all the actors in a single array list called `actors` and then loop over this list to paint them. Once you have done that you might like to add more actors to the stage.

💡 In my solution, I will declare the actors list as a `List` instead of an `ArrayList`. Any idea why? Why does this even work?

# Task 11

Turns out you are not able to use colours to distinguish the different types of actors! You are going to need to draw little shapes to represent them. You have been told you can't use images, you have to draw with Java2D primitives so the game can scale up and down as required. The `Graphics` objects we are painting on know how to draw `Polygon`s (https://docs.oracle.com/javase/8/docs/api/java/awt/Polygon.html) so that is what we are going to use. However, one polygon is not enough for each actor, we need each to be made of a list of polygons. We will use `ArrayList` again! Have the `Color` field of `Actor` changed to a list of polygons and initialise each subclass to an appropriate set of polygons. You might find the following polygons a useful starting point where `location` is the

