#include <iostream>
#include <string>
#include <vector>

int main(int argc, char *argv[]) {
   //get input from command line into a vector
    std::vector<std::string> a(argv, argv + argc);

    //convert the string vector to int vector
std::vector<int> numbers;
    for (int i=0; i< a.size(); i++){
        int num = atoi(a.at(i).c_str());
        numbers.push_back(num);
    }

//print size
int num = numbers.size();
std::cout << "Number of Elements: " << num << "\n";

//print elements
std::cout << "Elements: ";
for(int i = 1; i < numbers.size(); i++){
     std::cout << numbers.at(i) << ' ';
}
std::cout << "\n";

//print elements (even)
std::cout << "Even Elements: ";
for(int i = 1; i < numbers.size(); i++){
    int tempeven = numbers.at(i);
    if(tempeven %2 == 0){
        std::cout << numbers.at(i) << ' ';
    }
}
std::cout << "\n";

//print elements (odd)
std::cout << "Odd Elements: ";
for(int i = 1; i < numbers.size(); i++){
    int tempodd = numbers.at(i);
    if(tempodd %2 != 0){
        std::cout << numbers.at(i) << ' ';
    }
}
std::cout << "\n";

    return 0;
}

