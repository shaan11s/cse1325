#include <string>
#include <stdexcept>
#include "item.h"

    Item::Item(){
        _name = "coming soon";
        _price = 0;
    }
    Item::Item(std::string name, int price){
        if(price<0) throw std::runtime_error("AddPositiveIntegers arguments must be positive");
        _name = name;
        _price = price;
    }
    std::ostream& operator << (std::ostream& os, const Item& Item){
      std::string temp = Item._name;
        temp += " ($";
        temp += std::to_string(Item._price);
        temp += ")";
        os<<temp;
        return os;
    }
    std::istream& operator >> (std::istream& is, Item& Item){
        return is;
    }