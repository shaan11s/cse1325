#include <string>
#include <stdexcept>
#include <vector>
#include <iostream>
#include "vending_machine.h"
#include "item.h"

class vending_machine{

    private:

    std::vector<Item> items;

    public:

    void add(std::string name, int price){
      // Item temp(name, price);
       items.push_back(new Item(name, price));
    }

    void buy(int index){
        std::cout << "buying "; 
        Item temp = items.at(index);
        std::string temp_string = temp.tostring();
        std::cout << temp_string;
        std::cout << "\n"; 
    }

    std::string menu(){
        for(int i=0; i<items.size(); i++){
            std::string index = std::to_string(i);
            std::cout <<index << ") "; 
            Item temp2 = items.at(i);
            std::string temp_string = temp2.tostring();
            std::cout << temp_string;
            std::cout << "\n"; 
        }
        
    }

};