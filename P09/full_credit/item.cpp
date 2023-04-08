#include <string>
#include <stdexcept>
#include "item.h"

// class Item{

//     private:
//     std::string _name;
//     int _price;

//     public:
    Item::Item(std::string name, int price){
        if(price<0) throw std::runtime_error("AddPositiveIntegers arguments must be positive");
        _name = name;
        _price = price;
    }

    std::string Item::to_string(){
        std::string temp = _name;
        temp += " ($";
        temp += std::to_string(_price);
        temp += ")";
        return temp;
    }
// };