#include <string>
#include <stdexcept>
#include <vector>
#include <iostream>
#include "vending_machine.h"
#include "item.h"

    std::vector<Item> items;

    void vending_machine::add(std::string name, int price){
       Item temp(name, price);
       items.push_back(temp);
    }

    void vending_machine::buy(int index){
        std::cout << "buying "; 
        Item temp = items.at(index);
        std::cout << temp;
        std::cout << " \n"; 
    }

    std::ostream& operator << (std::ostream& os, const vending_machine& vending){

        for(int i=0; i<items.size(); i++){
        std::string index = std::to_string(i);
        Item temp2 = items.at(i);
        os << index << ") " <<  temp2 << "\n";
        }
        return os;
    }

    