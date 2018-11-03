# Lab 7: The Two Towers

## Useful Links
 * [Course Homepage](http://cs.williams.edu/~cs136/index.html) (with TA schedule)
 * [Lab Webpage](http://cs.williams.edu/~cs136/labs/two-towers.pdf)
 * [structure5](http://www.cs.williams.edu/~bailey/JavaStructures/doc/structure5/index.html) documentation
 * [GitHub markdown](https://guides.github.com/features/mastering-markdown/) syntax

 1. What is the best solution to the 15-block problem?
   * (answer)
 2. How long does it take your program to find the answer to the 20-block
 problem? Based on the time taken to solve the 20-block problem, about how long
 do you expect it would take to solve the 21-block problem? What is the actual
 time? How about the 25-block problem? Do these agree with your expectations,
 given the time complexity of the problem? What about the 40- and 50-block
 problems? (These will take a very long time. Just estimate based on the run
 times of the smaller problems). To answer this question, fill in the table below
 (you may wish to edit this file directly on GitHub so that you can view the
 table rendered using GitHub's markdown formatting)

 | Problem Size  | Estimated time | Actual Time |
 | :------------ | :------------: | :---------: |
 | 20 blocks     |       1 second(just under)       |  (answer)   |
 | 21 blocks     |    (answer)    |  (answer)   |
 | 22 blocks     |    (answer)    |  (answer)   |
 | 25 blocks     |    (answer)    |  (answer)   |
 | 40 blocks     |    (answer)    |     --      |
 | 50 blocks     |    (answer)    |     --      |

   * Explain how you arrived at your estimates.
     * (answer)
   * Do the actual timings agree with your expectations, given the time complexity of the problem?
     * (answer)

 3. This method of exhaustively checking the subsets of blocks will not work for
 very large problems. Consider, for example, the problem with 50 blocks: there
 are 2^50 different subsets. One approach is to repeatedly pick and evaluate
 random subsets of blocks (e.g., stop the computation after 1 second of elapsed
 time, printing the best subset found). How would you implement `randomSubset`, a
 new `SubsetIterator` method that returns a random subset? (Describe your
 strategy. You do not need to actually implement it.)
   * (answer)
