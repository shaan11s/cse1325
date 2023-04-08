#include <iostream>
#include <string>
#include <vector>
#include "vending_machine.h"
#include "item.h"

int main(int argc, char *argv[]) {

    vending_machine new_machine = vending_machine();

    new_machine.add("coke", 2);
    new_machine.add("pepsi", 2);
    std::string temp =new_machine.menu();
    std::cout << temp;
    new_machine.buy(0);
     return 0;
}

