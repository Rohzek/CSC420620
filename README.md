# CSC420620

A test/writeup of two small programs written in Java and C++ to test run times of the default built-in sorting algorithms.

Uses Collections::sort in Java, and std::sort in C++
Both programs read the text file into a collection (ArrayList in Java, and Vector in C++) and then sort that; both of them only account for the time taken sorting, 
and not the time spent reading the file, or writing the output file.

## Results:

With the provided testing file (A list of ~370K English words in random order) it took the Java implementation 196ms to sort the list of words, while it took the C++ implementation only 99ms.