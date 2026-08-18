Hi!

Welcome to the development team!

To get you familiar with our product,
we have a few tasks that we give to all of our new interns.

# IMPORTANT

If you encounter issues completing any of the tasks below:

1. Ask for targeted help on Piazza or in an office hour.
2. If it is an issue with the program not running on your machine despite
   your best efforts, please make use of the available lab machines to complete
   the tasks. Remote access options are available;
   see the course Quercus for details.

# Task 1

Make sure that you have a local copy that you are able to run:

`SweetHome3D` (`SweetHome3D/src/com/eteks/sweethome3d/SweetHome3D.java`)
is the file that contains the main method for the whole application.

`PrintTest` (`SweetHome3D/test/com/eteks/sweethome3d/junit/PrintTest.java`)
is one of the test files that you will need to work with.

Note: you may encounter some issues with missing requirements.
Carefully read the error messages and ask for help as needed.

-[ ] Commit a screenshot of the running application to your repo on MarkUs;
     the file name must include "task1" in the name.

> TODO have to check to ensure that 3D is properly disabled
> TODO do we want to set things up with Maven here?

# Task 2

New Feature: Adding descriptions for pieces of furniture

Hint: once you find the right place in the code,
this one is somewhat surprisingly just a single line change in the code!

-[ ] Commit another screenshot of this working, include "task2" in the file name.

> TODO make an automatic test of some kind for this one?

# Task 3

New Feature: Adding a volume column to the furniture table

Note: unlike the previous change, this one will require changes across
many files to get it fully implemented in the program.

Hint: TODO add some hints about specific constants to search for in the files?

> TODO ensure that we exhaustively catch everything in the program that
> needs to change to fully update this

-[ ] Commit your code on MarkUs.
-[ ] Commit another screenshot of this working, include "task3" in the file name.

> TODO decide what is best for them to submit here... decide on autotests too...
> TODO for the tests, look into running them on MarkUs or if we need to
>      run the GUI-related ones locally instead... note, it doesn't look
>      like running in headless mode is an option, but maybe there is something
>      that was overlooked...

# Task 4

New Feature: Printing all levels instead of only the currently active layer

> TODO decide on the exact framing, as we actually currently implemented this
>      as a change to the existing functionality rather than as something new...

-[ ] Commit your code on MarkUs.
-[ ] Commit another screenshot of this working, include "task4" in the file name.


# Task 5

Adding additional tests for your new features

TODO decide if we want them to do this or not...?