# Lab 7: The Two Towers

## Useful Links
 * [Course Homepage](http://cs.williams.edu/~cs136/index.html) (with TA schedule)
 * [Lab Webpage](http://cs.williams.edu/~cs136/labs/two-towers.pdf)
 * [structure5](http://www.cs.williams.edu/~bailey/JavaStructures/doc/structure5/index.html) documentation
 * [GitHub markdown](https://guides.github.com/features/mastering-markdown/) syntax

 1. What is the best solution to the 15-block problem?
   * {1, 2, 3, 4, 6, 7, 11, 14}
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
 | 20 blocks     |       --       |  (.63s)     |
 | 21 blocks     |    (1.26s)     |  (.91s)   |
 | 22 blocks     |    (2.52s)    |  (1.51s)   |
 | 23 blocks     |    (5.04s)     |  (2.73s)   |
 | 24 blocks     |    (10.08s)    |  (4.81s)   |
 | 25 blocks     |    (20.16s)    |  (9.25s)   |
 | 26 blocks     |    (40.32s)     | (18.40s)   |
 | 27 blocks     |    (80.64s)    |  (35.46s)   |
 | 40 blocks     |    (15 days)    |        |
 | 50 blocks     |    (34 years)    |     --      |

   * Explain how you arrived at your estimates.
     * The actual runtime of program for 20 blocks was just over half a second. I then examined the relation between the number of blocks and the number of operations my program performs. For every new block, there are 2 times as many subsets of blocks (2^n subset creations). For each subset of blocks, the program iterates through each of those blocks to find the subset's height (~n operations). So, if *O(n)= n*2^n*, then *O(n+1)= (n+1)*2^(n+1)*. To get from the number of operations with n blocks to that with n+1 blocks, roughly speaking, you multiply by 2 and by ((n+1)/n) (roughly one). So, to increment by one, I multiplied the result from 20 blocks (.63s) by two to estimate the result from 21 blocks, and by 2 again to estimate the result from 22 blocks, and so on. To estimate for 40 and 50 blocks, I stuck a bit more closely to the original derivation. If n=20, and O(n) 2^20*20 is .63, then O(n+20) is 2^20*.63*40/20 = 2*.63*2. Similarly, if n=20 and O(n) = .63, then O(50) = O(n+30) = 2^30*.63*50/20 = (approximately) 2^30*1. Converting into days and years yields the estimates above.
    * Do the actual timings agree with your expectations, given the time complexity of the problem?
     * Although the order of magnitude is generally the same between my estimates and the actual timings, the time complexity pattern that I deduced only starts to more clearly emerge after 22 blocks. If I had begun with the actual time for 22 blocks, and then extrapolated from there, my estimates would have been more accurate.

 3. This method of exhaustively checking the subsets of blocks will not work for
 very large problems. Consider, for example, the problem with 50 blocks: there
 are 2^50 different subsets. One approach is to repeatedly pick and evaluate
 random subsets of blocks (e.g., stop the computation after 1 second of elapsed
 time, printing the best subset found). How would you implement `randomSubset`, a
 new `SubsetIterator` method that returns a random subset? (Describe your
 strategy. You do not need to actually implement it.)
   * I would still use the a long variable as a representation of the subset of my choice. But, instead of incrementing that variable to cover every possible subset, I would just randomly generate ones and zeros for each digit of the binary representation. 
