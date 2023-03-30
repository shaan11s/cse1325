#include <iostream>
#include <string>
#include <vector>

int main(int argc, char *argv[]) {
   //get input from command line into a vector
    std::vector<std::string> a(argv, argv + argc);

 //if previous string is same as current string, skip 
for(int i = 1; i < a.size(); i++) 
{
    if (a[i] == a[i-1]) continue;
     std::cout << a.at(i) << ' ';
    
}
    return 0;
}
