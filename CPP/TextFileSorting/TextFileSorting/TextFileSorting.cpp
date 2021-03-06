#include "pch.h"
#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
#include <chrono>

using namespace std;
using namespace std::chrono;

int main(int argc, char *argv[])
{
	// Initialize required variables
	bool shouldsort = false;
	string file;
	vector<string> contents;
	ifstream textfilein;
	string line;
	ofstream textfileout;

	// Needs a single text file to be supplied
	// Count will always be at least 1, as argv[0] is the name of the program itself. 
	// We want argv[1] as first argument
	if(argc != 2) 
	{
		cout << "USAGE: Drag and drop a single text file onto the exe" << endl;
	}

	else
	{
		// Make sure what was provided is actually a text file
		file = argv[1];
		cout << "Sorting: " <<  file << endl;
		ifstream check(file);
		if (check)
		{
			shouldsort = true;
		}
	}

	if(shouldsort)
	{
		// Load and read file
		textfilein.open(file);
		while (getline(textfilein, line))
		{
			contents.push_back(line);
		}
		textfilein.close();

		// Get start time for sorting operation
		auto start = high_resolution_clock::now();

		// Sort list of contents
		sort(contents.begin(), contents.end());

		// Get end time for sorting operation
		auto stop = high_resolution_clock::now();

		// Calculate run time in miliseconds
		auto duration = duration_cast<milliseconds>(stop - start);

		// Write sorted list back to a file
		textfileout.open("output_cpp.txt");
		for (int i = 0; i < contents.size(); i++)
		{
			textfileout << contents[i] << "\n";
		}
		textfileout << "\nSorting took: " << duration.count() << "ms" << endl;
		textfileout.close();
		
		cout << "Sorting took: " << duration.count() << "ms" << endl;
	}

	cout << "\nPress enter key to exit" << endl;
	getchar();
}