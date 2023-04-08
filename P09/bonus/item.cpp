#include <string>
#include <stdexcept>
#include "item.h"

// class Item{

//     private:
//     std::string _name;
//     int _price;

//     public:
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

    // std::string Item::to_string(){
        // std::string temp = _name;
        // temp += " ($";
        // temp += std::to_string(_price);
        // temp += ")";
        // return temp;
    // }
// };