#include <string>
#include <stdexcept>
#include <vector>
#include <iostream>
#include "vending_machine.h"
#include "item.h"

// class vending_machine{

    // private:
    std::vector<Item> items;

    // public:
    void vending_machine::add(std::string name, int price){
       Item temp(name, price);
       items.push_back(temp);
    }

    void vending_machine::buy(int index){
        std::cout << "buying "; 
        Item temp = items.at(index);
        std::string temp_string = temp.to_string();
        std::cout << temp_string;
        std::cout << " \n"; 
    }

    std::string vending_machine::menu(){
        std::string output;
        for(int i=0; i<items.size(); i++){
            std::string index = std::to_string(i);
            output.append(index);
            output.append(") ");
            //std::cout <<index << ") "; 
            Item temp2 = items.at(i);
            std::string temp_string = temp2.to_string();
            output.append(temp_string);
            //std::cout << temp_string;
            output.append("\n");
            //std::cout << "\n"; 
        }
            return output;
    }

// };